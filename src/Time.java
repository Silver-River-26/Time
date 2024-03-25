public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;

    }

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void increment(int increment) {
        int hoursToAdd = increment / (60 * 60);
        int subtractHours = increment % (60 * 60);
        int minutesToAdd = subtractHours / 60;
        int secondsToAdd = subtractHours % 60;

        this.seconds = this.seconds + secondsToAdd;
        this.minutes = this.minutes + minutesToAdd;
        this.hours = this.hours + hoursToAdd;

        if (seconds >= 60) {
            minutes = minutes + (seconds / 60);
            seconds = seconds % 60;
        }
        if (minutes >= 60){
            hours = hours + (minutes / 60);
            minutes = minutes % 60;
        }




    }

    public void print(Boolean military) {
        if (military) {
            System.out.println(String.format("%d:%02d:%02d", hours, minutes, seconds));
        } else {
            if (hours > 12) {
                System.out.println(String.format("%d:%02d:%02d PM", (hours - 12), minutes, seconds));
            } else if (hours == 12) {
                System.out.println(String.format("%d:%02d:%02d PM", hours, minutes, seconds));
            } else if (hours > 0) {
                System.out.println(String.format("%d:%02d:%02d AM", hours, minutes, seconds));
            } else {
                System.out.println(String.format("%d:%02d:%02d AM", (hours + 12), minutes, seconds));
            }
        }

    }

    public static Time fromString(String time) {
        String[] split = time.split(":");
        Integer hours = Integer.parseInt(split[0]);
        Integer minutes = Integer.parseInt(split[1]);
        Integer seconds = Integer.parseInt(split[2]);
        return new Time(hours, minutes, seconds);

    }
}

