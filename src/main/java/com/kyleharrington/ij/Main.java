package com.kyleharrington.ij;


import org.scijava.ItemIO;
import org.scijava.command.Command;
import org.scijava.log.LogService;
import org.scijava.plugin.Menu;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.util.ColorRGB;
import sc.iview.SciView;
import sc.iview.vector.ClearGLVector3;
import sc.iview.vector.Vector3;

import static sc.iview.commands.MenuWeights.EDIT;
import static sc.iview.commands.MenuWeights.EDIT_ADD_SPHERE;

@Plugin(type = Command.class, menuRoot = "Plugins", //
        menu = { @Menu(label = "Kharrington", weight = EDIT) })
public class Main implements Command {

    @Parameter
    private LogService logService;

    @Parameter(type = ItemIO.OUTPUT)
    private String infoString = "Kharrington IJ update site requires: SciView, SNT";

    @Override
    public void run() {
        logService.warn(infoString);
    }

    static public void main(String[] args) {

    }
}

