package com.kyleharrington.ij;


import org.scijava.command.Command;
import org.scijava.plugin.Menu;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.util.ColorRGB;
import sc.iview.SciView;
import sc.iview.vector.ClearGLVector3;
import sc.iview.vector.Vector3;

import static sc.iview.commands.MenuWeights.EDIT;
import static sc.iview.commands.MenuWeights.EDIT_ADD_SPHERE;

@Plugin(type = Command.class, menuRoot = "SciView", //
        menu = { @Menu(label = "Edit", weight = EDIT), //
                 @Menu(label = "Add Sphere...", weight = EDIT_ADD_SPHERE) })
public class Main implements Command {

    @Parameter
    private SciView sciView;

    @Parameter
    private String position = "0; 0; 0";

    @Parameter
    private float radius = 1.0f;

    @Parameter
    private ColorRGB color = SciView.DEFAULT_COLOR;

    @Override
    public void run() {
        final Vector3 pos = ClearGLVector3.parse( position );
        sciView.addSphere( pos, radius, color );
    }

    static public void main(String[] args) {

    }
}

