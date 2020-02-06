package festivalPlanner.gui.gui_controllers;

import planner_viewer.TimeLineView;

public class TimeLineViewScrollController {

    private TimeLineView timeLineView;
    private int xPosition;

    public TimeLineViewScrollController(TimeLineView timeLineView) {
        this.timeLineView = timeLineView;
        this.xPosition=0;
    }

    public void shiftToRight(){
        if(xPosition < 0) {
            xPosition += 115;
            timeLineView.setLayoutX(xPosition);
            timeLineView.setTranslateX(xPosition);
        }
    }

    public void shiftToLeft(){
        if(xPosition >= -1380) {
            xPosition -= 115;
            timeLineView.setLayoutX(xPosition);
            timeLineView.setTranslateX(xPosition);
        }
    }
}
