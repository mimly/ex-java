package mvc;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class MVC {
    public static void main (String[] args) {
        Model model = new PlainModel();
        View view1 = new PlainView(model);
        model.addView(view1);
        View view2 = new FancyView(model);
        model.addView(view2);
        Controller controller = new PlainController(model);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int state = scanner.nextInt();
            controller.setModelState(state);
        }
    }
}

// read/write methods
interface Model {
    void addView(View view);
    void removeView(View view);
    void notify(Model model);

    int getState();
    void setState(int state);
}

class PlainModel implements Model {
    private final List<View> views = new ArrayList<>();
    private int state = 0;

    @Override
    public void addView(View view) {
        views.add(view);
    }

    @Override
    public void removeView(View view) {
        views.remove(view);
    }

    @Override
    public void notify(Model model) {
        for (View view : views) {
            view.modelChanged(model);
        }
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public void setState(int state) {
        this.state = state;
        notify(this);
    }
}

// output, read methods
interface View {
    void modelChanged(Model model);
}

class PlainView implements View {
    private final Model model;

    public PlainView(Model model) {
        this.model = model;
    }

    @Override
    public void modelChanged(Model model) {
        System.out.println("state: " + model.getState());
    }
}

class FancyView implements View {
    private final Model model;

    public FancyView(Model model) {
        this.model = model;
    }

    @Override
    public void modelChanged(Model model) {
        System.out.println("\033[1;38;5;42mThe \033[1;38;5;192mstate\033[1;38;5;42m of the model is now \033[1;38;5;192m" + model.getState() + "\033[0m");
    }
}

// input, write methods
interface Controller {
    void setModelState(int state);
}

class PlainController implements Controller {
    private final Model model;

    public PlainController(Model model) {
        this.model = model;
    }

    @Override
    public void setModelState(int state) {
        this.model.setState(state);
    }
}
