package com.xuexi;

import java.util.Scanner;

import com.xuexi.Supermarket.Customer;
import com.xuexi.Supermarket.Fruit;

public class Supermarket {  
    
    // 水果类，用于存储价格和数量  
    static class Fruit {  
        String name;  
        double pricePerJin;  
  
        Fruit(String name, double pricePerJin) {  
            this.name = name;  
            this.pricePerJin = pricePerJin;  
        }  
  
        double getTotalPrice(double quantity) {  
            return pricePerJin * quantity;  
        }  
    }  
  
    // 顾客类，用于存储购买的水果和计算总价  
    static class Customer {  
        private Fruit apple = new Fruit("苹果", 8);  
        private Fruit strawberry = new Fruit("草莓", 13);  
        private Fruit mango = new Fruit("芒果", 20);  
  
        // 场景1：计算苹果和草莓的总价  
        double calculatePriceForA(double apples, double strawberries) {  
            return apple.getTotalPrice(apples) + strawberry.getTotalPrice(strawberries);  
        }  
  
        // 场景2：计算苹果、草莓和芒果的总价  
        double calculatePriceForB(double apples, double strawberries, double mangoes) {  
            return calculatePriceForA(apples, strawberries) + mango.getTotalPrice(mangoes);  
        }  
  
        // 场景3：计算苹果、草莓（打8折）和芒果的总价  
        double calculatePriceForC(double apples, double strawberries, double mangoes) {  
            return calculatePriceForB(apples, strawberries, mangoes) - strawberry.getTotalPrice(strawberries) * 0.2;  
        }  
  
        // 场景4：计算苹果、草莓（打8折）、芒果，并应用满100减10的优惠  
        double calculatePriceForD(double apples, double strawberries, double mangoes) {  
            double total = calculatePriceForC(apples, strawberries, mangoes);  
            return total >= 100 ? total - 10 : total;  
        }  
    }  
    
    public static void test(Customer customer) {
    	if(customer == null ) {
    		customer = new Customer();
    	}
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("请输入要测试的场景：（目前具有1、2、3、4场景测试）");
    	int scene = scanner.nextInt();
    	double appleSum,strawberrySun,mangoSum,totalPrice;
    	switch (scene) {
    	    case 1:
    	    	System.out.println("请输入要购买的苹果斤数：");
    	    	appleSum = scanner.nextDouble();
    	    	System.out.println("请输入要购买的草莓斤数：");
    	    	strawberrySun = scanner.nextDouble();
    	    	totalPrice = customer.calculatePriceForA(appleSum, strawberrySun);
    	    	System.out.println("该顾客购买了"+appleSum+"斤苹果和"+strawberrySun+"斤草莓需要支付"+totalPrice+"元");
    	    case 2:
    	    	System.out.println("请输入要购买的苹果斤数：");
    	    	appleSum = scanner.nextDouble();
    	    	System.out.println("请输入要购买的草莓斤数：");
    	    	strawberrySun = scanner.nextDouble();
    	    	System.out.println("请输入要购买的芒果斤数：");
    	    	mangoSum = scanner.nextDouble();
    	    	totalPrice = customer.calculatePriceForB(appleSum, strawberrySun,mangoSum);
    	    	System.out.println("该顾客购买了"+appleSum+"斤苹果和"+strawberrySun+"斤草莓和"+mangoSum+"斤芒果需要支付"+totalPrice+"元");    	        
    	    case 3:
    	    	System.out.println("请输入要购买的苹果斤数：");
    	    	appleSum = scanner.nextDouble();
    	    	System.out.println("请输入要购买的草莓斤数：");
    	    	strawberrySun = scanner.nextDouble();
    	    	System.out.println("请输入要购买的芒果斤数：");
    	    	mangoSum = scanner.nextDouble();
    	    	totalPrice = customer.calculatePriceForC(appleSum, strawberrySun,mangoSum);
    	    	System.out.println("该顾客购买了"+appleSum+"斤苹果和"+strawberrySun+"斤草莓和"+mangoSum+"斤芒果需要支付"+totalPrice+"元");    	        
    	    case 4:
    	    	System.out.println("请输入要购买的苹果斤数：");
    	    	appleSum = scanner.nextDouble();
    	    	System.out.println("请输入要购买的草莓斤数：");
    	    	strawberrySun = scanner.nextDouble();
    	    	System.out.println("请输入要购买的芒果斤数：");
    	    	mangoSum = scanner.nextDouble();
    	    	totalPrice = customer.calculatePriceForD(appleSum, strawberrySun,mangoSum);
    	    	System.out.println("该顾客购买了"+appleSum+"斤苹果和"+strawberrySun+"斤草莓和"+mangoSum+"斤芒果需要支付"+totalPrice+"元");    	        
    	}
    	test(customer);

    }
  
    public static void main(String[] args) {
        test(new Customer());
    }  
}
