package Question2;

public class Job {

    private int value;
    private int priority;

    public Job(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }
// getter setter methods
    public int getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return " "+ value+"("+priority+")";
    }
}
