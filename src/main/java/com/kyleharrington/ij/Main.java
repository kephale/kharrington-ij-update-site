package com.kyleharrington.ij;


import org.scijava.ItemIO;
import org.scijava.command.Command;
import org.scijava.log.LogService;
import org.scijava.plugin.Menu;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

import static sc.iview.commands.MenuWeights.EDIT;

@Plugin(type = Command.class, menuRoot = "Help", //
        menu = { @Menu(label = "About Kharrington update site", weight = EDIT) })
public class Main implements Command {

    @Parameter
    private LogService logService;

    @Parameter(type = ItemIO.OUTPUT)
    private String infoString = "Kharrington Fiji update site\n" +
            "The site includes bleeding edge versions of SciView, scenery, SNT, Cx3D, and other tools." +
            "The common theme of all these tools are that Kyle Harrington decided to put them all into the same update site.";

    @Override
    public void run() {
        logService.warn(infoString);
    }

    static public void main(String[] args) {

    }
}

