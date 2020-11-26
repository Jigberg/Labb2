package Base_Classes;

import Uncategorized.IFatigue;

public class Kangaroo implements IFatigue {
    @Override
    public Double checkFatigueLevel() {
        return 0.9;
    }
}
