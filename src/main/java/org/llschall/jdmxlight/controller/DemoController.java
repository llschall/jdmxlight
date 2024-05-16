package org.llschall.jdmxlight.controller;

import org.llschall.jdmxlight.model.DemoModel;
import org.llschall.jdmxlight.view.DemoView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DemoController {

    public void start() {

        DemoModel model = new DemoModel();
        DemoView view = new DemoView(model);

        view.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if (code==27) {
                    System.exit(0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        view.display();
    }


}
