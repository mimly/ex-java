package threads;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

public class WeatherSimulator extends Thread {

    // size 13
    private static final List<String> WEATHER_ICONS = List.of("☀️", "🌤", "🌤️", "⛅", "🌥️", "🌥", "🌦️", "🌦", "🌧️", "🌧", "⛈️", "⛈", "🌩");
    private static final long REFRESH_RATE = 3000l; // change weather every 3 seconds
    private final Random random = new Random();
    private int numberOfIcons = 26;
    private int startIndex = 0;
    private int endIndex = 4;
    private String currentWeather = createWeatherString();

    private String createWeatherString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.numberOfIcons; ++i) {
            List<String> subsetOfWeatherIcons = WeatherSimulator.WEATHER_ICONS.subList(this.startIndex, this.endIndex);
            int randomIndex = random.nextInt(subsetOfWeatherIcons.size());
            String icon = subsetOfWeatherIcons.get(randomIndex);
            stringBuilder.append(icon);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return this.currentWeather;
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.startIndex = (this.startIndex + random.nextInt(4)) % WeatherSimulator.WEATHER_ICONS.size();
                this.endIndex = this.startIndex + random.nextInt(2) + 3; // variation of 3 or 4 icons
                if (this.endIndex >= WeatherSimulator.WEATHER_ICONS.size()) {
                    this.endIndex = WeatherSimulator.WEATHER_ICONS.size();
                }

                // change weather every 3 seconds
                this.currentWeather = createWeatherString();
                Thread.sleep(WeatherSimulator.REFRESH_RATE);
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public static void main (String[] args) throws InterruptedException {
        // by extending the Thread class
        WeatherSimulator weatherSimulator = new WeatherSimulator();
        weatherSimulator.start();

        // by implementing the Runnable interface
        // WeatherSimulator weatherSimulator = new WeatherSimulator();
        // new Thread(weatherSimulator).start();

        while (true) {
            LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
            String currentWeather = weatherSimulator.toString();
            System.out.println(String.format(
                "\033[2J\033[0;0H\033[1;38;5;223m%s\033[0;0m\n\033[1000D%s\033[0K\033[0K",
                currentTime + " Weather Simulator...",
                currentWeather
            ));
            System.out.flush();

            Thread.sleep(1000l);
        }
    }
}
