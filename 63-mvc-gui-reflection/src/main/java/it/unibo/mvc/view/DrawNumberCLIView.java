package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

/**
 * The class {@link DrawNumberCLIView} is a <b>output only</b> view implementation.
 * It implements the {@link DrawNumberView} {@code interface}.
 */
public final class DrawNumberCLIView implements DrawNumberView {

    @Override
    public void setController(DrawNumberController observer) { }

    @Override
    public void start() { }

    @Override
    public void result(DrawResult res) {
        System.out.println(res.getDescription());
    }
    
}
