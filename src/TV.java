/**
 * Name:
 * Due Date:
 * Description: This is a class that represents a single TV in the store
 * Version: 1.0
 */

public class TV {
    private String tvId;

    public TV() {
        tvId = null;
    }

    public TV(String tvId) {
        this.tvId = tvId;
    }

    public String getTvId() {
        return tvId;
    }

    public void setTvId(String tvId) {
        this.tvId = tvId;
    }

    @Override
    public String toString() {
        return "The TV id number is: "+tvId;
    }
}


