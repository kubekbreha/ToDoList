package com.spacecode.brehuv.todolist.task;

import com.cloudant.sync.documentstore.DocumentRevision;

import java.util.HashMap;
import java.util.Map;


/**
 * Task object.
 */
public class Task {

    /**
     * Constructors.
     */
    private Task() {
    }

    public Task(String desc) {
        this.setDescription(desc);
        this.setCompleted(false);
        this.setType(DOC_TYPE);
    }

    /**
     * Rec section.
     */
    private DocumentRevision rev;

    // this is the revision in the database representing this task
    public DocumentRevision getDocumentRevision() {
        return rev;
    }


    /**
     * Type section.
     */
    static final String DOC_TYPE = "com.cloudant.sync.example.task";
    private String type = DOC_TYPE;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    /**
     * Task status(completed) section.
     */
    private boolean completed;

    public boolean isCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    /**
     * Description section.
     */
    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }


    @Override
    public String toString() {
        return "{ desc: " + getDescription() + ", completed: " + isCompleted() + "}";
    }


    public static Task fromRevision(DocumentRevision rev) {
        Task t = new Task();
        t.rev = rev;
        // this could also be done by a fancy object mapper
        Map<String, Object> map = rev.getBody().asMap();
        if(map.containsKey("type") && map.get("type").equals(Task.DOC_TYPE)) {
            t.setType((String) map.get("type"));
            t.setCompleted((Boolean) map.get("completed"));
            t.setDescription((String) map.get("description"));
            return t;
        }
        return null;
    }


    public Map<String, Object> asMap() {
        // this could also be done by a fancy object mapper
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("type", type);
        map.put("completed", completed);
        map.put("description", description);
        return map;
    }

}
