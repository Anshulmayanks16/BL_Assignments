
import java.util.*;

// 1. MealPlan Interface (Common Behavior for All Meal Types)
interface MealPlan {
    String getMealName();
    int getCalories();
    void displayMealDetails();
}

// 2. Specific Meal Categories
class VegetarianMeal implements MealPlan {
    private String mealName;
    private int calories;

    public VegetarianMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public void displayMealDetails() {
        System.out.println(" Vegetarian Meal: " + mealName + " | Calories: " + calories);
    }
}

class VeganMeal implements MealPlan {
    private String mealName;
    private int calories;

    public VeganMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public void displayMealDetails() {
        System.out.println(" Vegan Meal: " + mealName + " | Calories: " + calories);
    }
}

class KetoMeal implements MealPlan {
    private String mealName;
    private int calories;

    public KetoMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public void displayMealDetails() {
        System.out.println("🥓 Keto Meal: " + mealName + " | Calories: " + calories);
    }
}

class HighProteinMeal implements MealPlan {
    private String mealName;
    private int calories;

    public HighProteinMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public void displayMealDetails() {
        System.out.println(" High-Protein Meal: " + mealName + " | Calories: " + calories);
    }
}

// 3. Generic Meal Wrapper Class
class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public T getMeal() {
        return meal;
    }

    public void displayMeal() {
        meal.displayMealDetails();
    }
}

// 4. Meal Plan Manager (Handles Multiple Meal Categories)
class MealPlanManager {
    private List<Meal<? extends MealPlan>> mealPlans = new ArrayList<>();

    // Generic Method to Add a Meal
    public <T extends MealPlan> void addMeal(Meal<T> meal) {
        mealPlans.add(meal);
    }

    // Display All Meals
    public void displayAllMeals() {
        for (Meal<? extends MealPlan> meal : mealPlans) {
            meal.displayMeal();
            System.out.println("----------------------------------");
        }
    }

    // Generic Method to Generate a Personalized Meal Plan
    public <T extends MealPlan> Meal<T> generateMealPlan(T meal) {
        System.out.println(" Generating Meal Plan for: " + meal.getMealName());
        return new Meal<>(meal);
    }
}

// 5. Main Class (Testing the System)
public class PersonalizedMealPlan {
    public static void main(String[] args) {
        // Create Specific Meal Instances
        VegetarianMeal vegMeal = new VegetarianMeal("Grilled Veggie Bowl", 400);
        VeganMeal veganMeal = new VeganMeal("Tofu Stir-Fry", 350);
        KetoMeal ketoMeal = new KetoMeal("Bacon Avocado Salad", 600);
        HighProteinMeal proteinMeal = new HighProteinMeal("Chicken Breast with Quinoa", 700);

        // Meal Wrapper (Generic Class Usage)
        Meal<VegetarianMeal> vegPlan = new Meal<>(vegMeal);
        Meal<VeganMeal> veganPlan = new Meal<>(veganMeal);
        Meal<KetoMeal> ketoPlan = new Meal<>(ketoMeal);
        Meal<HighProteinMeal> proteinPlan = new Meal<>(proteinMeal);

        // Meal Plan Manager
        MealPlanManager manager = new MealPlanManager();

        // Add Meals to the Plan
        manager.addMeal(vegPlan);
        manager.addMeal(veganPlan);
        manager.addMeal(ketoPlan);
        manager.addMeal(proteinPlan);

        // Display All Available Meal Plans
        System.out.println("🍽️ Available Meal Plans:");
        manager.displayAllMeals();

        // Generate Personalized Meal Plans
        System.out.println("\n Personalized Meal Plan Generation:");
        Meal<VeganMeal> personalizedVegan = manager.generateMealPlan(new VeganMeal("Avocado Sushi", 320));
        personalizedVegan.displayMeal();
    }
}