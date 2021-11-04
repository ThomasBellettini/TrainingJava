package fr.shurisko;

import fr.shurisko.entity.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ShopDisplay {

    public static ShopDisplay getInstance;

    public final List<Item> itemList = new ArrayList<>();

    private void print(String str) {
        System.out.println(str);
    }

    public Item getItem(Scanner scanner) {
        String name = null;
        String desc = null;
        double price = -1;

        print("Name: ");
        while (name == null || name.equalsIgnoreCase("") || name.isEmpty())
            name = scanner.nextLine();
        print("Description: ");
        while (desc == null || desc.equalsIgnoreCase("") || desc.isEmpty())
            desc = scanner.nextLine();
        print("Price: ");
        while (price == -1) {
            String tmp = scanner.nextLine();
            try {
                price = Double.parseDouble(tmp);
            } catch (NumberFormatException e) {
                continue;
            }
        }
        Item item = new Item(name, desc, price);
        return item;
    }

    public ShopDisplay() {
        getInstance = this;

        Scanner scanner = new Scanner(System.in);
        boolean stopProg = false;

        while (!stopProg) {
            String str = scanner.nextLine();
            switch (str.toLowerCase(Locale.ROOT).replace(" ", "")) {
                case "add":
                    Item itm = getItem(scanner);
                    if (itm == null) {
                        print("Item was not correctly added!");
                        break;
                    }
                    this.itemList.add(itm);
                    print("U have entered an item (" + itm.getName() + ", " + itm.getDescription() + ", "+ itm.getPrice() +")");
                    break;
                case "show":
                    for (Item item : itemList) {
                        print("Item N°" + item.ID);
                        print("  - Name : " + item.getName());
                        print("  - Description : " + item.getDescription());
                        print("  - Price : " + item.getPrice());
                    }
                    break;
                case "stop":
                    stopProg = true;
                    break;
                default:
                    print("Error, Syntax: add / show / stop");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new ShopDisplay();
    }

}
