package todo.list;

public class task {
	 private static int count = 0;
	    private int id = 0;
	    private String description;
	    private boolean completed;


		public task(String description) {
	        this.id = ++count;
	        this.description = description;
	        this.completed = false;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public boolean isCompleted() {
	        return completed;
	    }
	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public void setCompleted(boolean completed) {
	        this.completed = completed;
	    }

	    @Override
	    public String toString() {
	        return String.format("%d. [%s] %s", id, (completed ? "X" : " "), description);
	    }

}
