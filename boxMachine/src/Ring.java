public class Ring {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void run() {

        if (checkWeight()) {
            while (this.f1.health > 0 && this.f2.health > 0) {
                System.out.println("======== NEW ROUND ===========");
                this.f2.health = this.f1.hit(f2);
                if (isWin()) {
                    break;
                }
                this.f1.health = this.f2.hit(f1);
                if (isWin()) {
                    break;
                }
                printScore();
            }
        } else {
            System.out.println("Weight of Players are not Equal!.");
        }


    }

    public boolean checkWeight() {
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight)
                && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    public boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println("Win the Game : " + f2.name);
            return true;
        } else if (this.f2.health == 0) {
            System.out.println("Win the Game : " + f1.name);
            return true;
        }

        return false;
    }


    public void printScore() {
        System.out.println("------------");
        System.out.println(f1.name + " remaining lives \t:" + this.f1.health);
        System.out.println(f2.name + " remaining lives \t:" + this.f2.health);
    }

}

