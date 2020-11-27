package SpeedChange;

import Movement.Speed;

public class SpeedChangeStrategy {
    private Speed speed;

    public Double calculateSpeedChange(Double amount){ return getSpeed().getPower()*0.01 + amount; }
    Speed getSpeed(){ return this.speed; }
}
