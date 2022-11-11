package com.patikadev.Helper;

import javax.swing.*;
import java.awt.*;

public class FocusablePanel  extends JPanel {

    public FocusablePanel(LayoutManager layout) {
        super(layout);

    }
    public boolean isFocusTraversable() {
        return true;
    }

    public void addFocusListener(MyDateChooser myDateChooser) {
    }

    public void addKeyListener(MyDateChooser myDateChooser) {
    }

}

