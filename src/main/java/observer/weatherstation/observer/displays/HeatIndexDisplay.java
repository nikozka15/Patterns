package observer.weatherstation.observer.displays;

import observer.weatherstation.observer.subject.WeatherData;

public class HeatIndexDisplay implements Observer, DisplayElement {
   private float heatIndex = 0.0f;
  WeatherData weatherData;
  public HeatIndexDisplay(WeatherData weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }
  @Override
  public void display() {
    System.out.println("Heat index is " + heatIndex);
  }

   private float computeHeatIndex(float temperature, float relativeHumidity) {
    float heatIndex = (float)((16.923 + (0.185212 * temperature) +
      (5.37941 * relativeHumidity) - (0.100254 * temperature * relativeHumidity) +
      (0.00941695 * (temperature * temperature)) +
      (0.00728898 * (relativeHumidity * relativeHumidity)) +
      (0.000345372 * (temperature * temperature * relativeHumidity)) -
      (0.000814971 * (temperature * relativeHumidity * relativeHumidity)) +
      (0.0000102102 * (temperature * temperature * relativeHumidity * relativeHumidity)) -
      (0.000038646 * (temperature * temperature * temperature)) +
      (0.0000291583 * (relativeHumidity * relativeHumidity * relativeHumidity)) +
      (0.00000142721 * (temperature * temperature * temperature * relativeHumidity)) +
      (0.000000197483 * (temperature * relativeHumidity * relativeHumidity * relativeHumidity)) -
      (0.0000000218429 * (temperature * temperature * temperature * relativeHumidity * relativeHumidity)) +
      0.000000000843296 * (temperature * temperature * relativeHumidity * relativeHumidity * relativeHumidity)) -
      (0.0000000000481975 * (temperature * temperature * temperature * relativeHumidity * relativeHumidity * relativeHumidity)));
    return heatIndex;
  }

  @Override
  public void update() {
    heatIndex = computeHeatIndex(weatherData.getTemperature(), weatherData.getHumidity());
      display();
    }
}
