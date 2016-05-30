package trader;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Todo {

    private String title;
    private int id;
    private Boolean completed;
    private Integer order;

    public void setId(int id){
        this.id = id;
    }

    public Todo patchFrom(Todo patch) {

        if (patch.completed != null) {
            completed = patch.completed;
        }

        if (patch.title != null) {
            title = patch.title;
        }

        if (patch.order != null) {
            order = patch.order;
        }

        return this;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}