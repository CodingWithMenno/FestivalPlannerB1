package festivalPlanner.gui.gui_controllers;

import planner_viewer.TimeLineView;

public class TimeLineViewScrollController {

    private TimeLineView timeLineView;
    private int xPosition;

    public TimeLineViewScrollController(TimeLineView timeLineView) {
        this.timeLineView = timeLineView;
        this.xPosition=150;
    }

    public void shiftToRight(){
        if(xPosition < 140) {
            xPosition += 115;
            timeLineView.sliderContainer.setLayoutX(xPosition);
            timeLineView.sliderContainer.setTranslateX(xPosition);
        }
    }

    public void shiftToLeft(){  //todo fix whitespace
        if(xPosition >= -1495) {
            xPosition -= 115;
            timeLineView.sliderContainer.setLayoutX(xPosition);
            timeLineView.sliderContainer.setTranslateX(xPosition);
        }
    }
}
