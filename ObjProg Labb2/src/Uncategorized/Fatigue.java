package Uncategorized;

public class Fatigue<B extends IFatigue> {
    private double fatigueLevel;
    private final B belongsTo;
    public Fatigue(B belongsTo, Double fatigueLevel){
        this.fatigueLevel = fatigueLevel;
        this.belongsTo = belongsTo;
    }
    double getFatigueValue(){ return getBelongsTo().checkFatigueLevel(); }
    B getBelongsTo(){ return belongsTo; }

}
