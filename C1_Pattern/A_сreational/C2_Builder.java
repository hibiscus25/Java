package C1_Pattern.A_сreational;


class SportCar{
    private String name;
    private String color;
    private int maxSpeed;

    private SportCar(Builder builder) {                  // приходит Builder
        this.name = builder.name;
        this.color = builder.color;
        this.maxSpeed = builder.maxSpeed;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "SportCar{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    static class Builder{
        private String name;
            private String color;
            private int maxSpeed;

        public Builder(String name) {                  // конструктор с основными полями (без которых не может существовать объект)
            this.name = name;
        }

            public Builder setColor(String color) {         // у остальных полей set
                this.color = color;
                return this;                                        //добавляет set и возвращает новый объект
            }

            public Builder setMaxSpeed(int maxSpeed) {
                this.maxSpeed = maxSpeed;
                return this;
            }

        public SportCar build(){                        // метод возвращает объект SportCar(Builder builder)
            return new SportCar(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "name='" + name + '\'' +
                    ", color='" + color + '\'' +
                    ", maxSpeed=" + maxSpeed +
                    '}';
        }
    }
}


public class C2_Builder {
    public static void main(String[] args) {
        SportCar sportCar = new SportCar.Builder("Audi").setColor("green").setMaxSpeed(300).build();
            //процесс создания
                SportCar.Builder builder = new SportCar.Builder("Audi");
                SportCar.Builder builder2 = new SportCar.Builder("Audi").setColor("green");
                SportCar.Builder builder3 = new SportCar.Builder("Audi").setColor("green").setMaxSpeed(300);

        System.out.println(builder);
        System.out.println(builder2);
        System.out.println(builder3);
            System.out.println(builder == builder2);
            System.out.println(builder == builder3);
            System.out.println(builder2 == builder3);

        System.out.println(sportCar);
            System.out.println(sportCar.getName());
            System.out.println(sportCar.getColor());
            System.out.println(sportCar.getMaxSpeed());

    }
}
