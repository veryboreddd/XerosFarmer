package script;

import com.client.t;
import game.farming.patch.Farm;
import game.farming.patch.HerbPatch;
import simple.api.script.Category;
import simple.api.script.Script;
import simple.api.script.ScriptManifest;
import utilities.FarmTimer;

import java.util.*;

@ScriptManifest(
        description = "Xeros farming script.", servers = {"Xeros"}, name = "X-Farmer", version = "1.00",
        category = Category.FARMING, discord = "veryboreddd#3118", author = "Fluffyman"
)
public class Farmer extends Script {
    public static Map<FarmTimer, HerbPatch> PLANTED_HERBS = new HashMap();
    public static List<HerbPatch> finishedHerbsList = new ArrayList<>();
    public static List<HerbPatch> emptyPatchList = Arrays.asList(new HerbPatch(Farm.FALADOR));

    @Override
    public boolean onExecute() {
        disableInput();
        toggleDebug();
        return true;
    }

    @Override
    public void onProcess() {
        if(!PLANTED_HERBS.isEmpty()) {
            PLANTED_HERBS.entrySet().forEach(entry -> {
                FarmTimer timer = entry.getKey();

                if(timer.finished()) {
                    if(!finishedHerbsList.contains(entry.getValue())) {
                        finishedHerbsList.add(entry.getValue());
                    }
                }
            });
        }

        if(!finishedHerbsList.isEmpty()) {
            finishedHerbsList.forEach(finishedHerb -> {
                if(finishedHerb.isPickable()) {
                    if(finishedHerb.pickPatch()) {
                        emptyPatchList.add(finishedHerb);
                        finishedHerbsList.remove(finishedHerb);
                    }
                }
            });
        }

        if(!emptyPatchList.isEmpty()) {
            emptyPatchList.forEach(emptyPatch -> {
                if (emptyPatch.teleport()) {
                    if (emptyPatch.getPatch() != null) {
                        if (emptyPatch.isHerbGrowing()) {
                            if (emptyPatch.isPickable()) {
                                if (emptyPatch.pickPatch()) {
                                    return;
                                }
                            } else {

                            }
                        } else {
                            if (emptyPatch.isRaked()) {
                                if (emptyPatch.plantHerbSeed()) {
                                    emptyPatchList.remove(emptyPatch);
                                }
                            } else {
                                if (emptyPatch.rakePatch()) {
                                    if (emptyPatch.plantHerbSeed()) {
                                        emptyPatchList.remove(emptyPatch);
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    @Override
    public void onTerminate() {

    }

    private void toggleDebug() {
        t.u = true;
    }

    private void disableInput() {
        ctx.mouse.blockInput(true);
    }
}
