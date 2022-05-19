package patterns;

import java.util.ArrayList;
import java.util.List;

public class InterceptingFilterLesson {
    static FilterManager filterManager = new FilterManager();
    public static void main(String[] args) {
        filterManager.setFilter(new AuthFilter());
        filterManager.setFilter(new IpFilter());
        filterManager.filterRequest("home");
    }
}

interface Filter {
    void execute(String data);
}

class AuthFilter implements Filter {
    @Override
    public void execute(String data) {
        System.out.println("auth filter data: " + data);
    }
}

class IpFilter implements Filter {
    @Override
    public void execute(String data) {
        System.out.println("ip filter data: " + data);
    }
}

class FilterChain {
    List<Filter> filterList = new ArrayList<>();
    Target target = new Target();
    void addFilter(Filter filter) {
        filterList.add(filter);
    }

    void filter(String data) {
        for (Filter filter : filterList) {
            filter.execute(data);
        }
        target.doJob(data);
    }
}

class FilterManager {
    FilterChain  filterChain = new FilterChain();

    void setFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    void filterRequest(String request) {
        filterChain.filter(request);
    }
}

class Target {
    void doJob(String data) {
        System.out.println("data came in: " + data);
    }
}