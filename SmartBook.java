import java.util.HashMap;
import java.util.Objects;

public class SmartBook {

    private String brand;
    private int ram;
    private int storageCapacity;
    private String operatingSystem;
    private String color;

    public SmartBook(String brand, int ram, int storageCapacity, String operatingSystem, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storageCapacity = storageCapacity;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return  "Бренд: " + brand + " \n" +
                "ОЗУ: " + ram + " \n" +
                "Ёмкость HDD: " + storageCapacity + " \n" +
                "Операционная система: " + operatingSystem + " \n" +
                "Цвет: " + color + " \n";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
          return  true;
        }
        if( o == null || getClass() != o) {
            return false;
        }
        SmartBook smsm = (SmartBook)o;
        return Objects.equals(brand, smsm.brand) && ram == smsm.ram && storageCapacity == smsm.storageCapacity && Objects.equals(operatingSystem, smsm.operatingSystem) && Objects.equals(color, smsm.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, ram, storageCapacity, operatingSystem, color);
    }

    public HashMap<Integer, String> toHashMap() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, brand);
        map.put(2, Integer.toString(ram));
        map.put(3, Integer.toString(storageCapacity));
        map.put(4, operatingSystem);
        map.put(5, color);
        return map;
    }

}