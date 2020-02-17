package festivalPlanner.gui.gui_controllers;

import planner_viewer.TimeLineView;

/**
 * in this class the logic for the timeline is set up.
 */

public class TimeLineViewScrollController {

    private TimeLineView timeLineView;
    private int xPosition;

    public TimeLineViewScrollController(TimeLineView timeLineView) {
        this.timeLineView = timeLineView;
        this.xPosition=150;
    }

    /**
     * this method shifts the timeline to the right with coordinates
     */
    public void shiftToRight(){
        if(xPosition < 140) {
            xPosition += 115;
            timeLineView.sliderContainer.setLayoutX(xPosition);
            timeLineView.sliderContainer.setTranslateX(xPosition);
        }
    }

    /**
     * this method shifts the timeline to the left with coordinates
     */
    public void shiftToLeft(){
        if(xPosition >= -1495) {
            xPosition -= 115;
            timeLineView.sliderContainer.setLayoutX(xPosition);
            timeLineView.sliderContainer.setTranslateX(xPosition);
        }
    }
}
