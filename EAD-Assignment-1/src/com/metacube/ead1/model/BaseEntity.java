package com.metacube.ead1.model;

public class BaseEntity {

    private int id;

    // Getters and Setters Methods
    public BaseEntity(int id) {
        this.id = id;
    }
    public BaseEntity(){
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BaseEntity other = (BaseEntity) obj;
        if (id != other.id)
            return false;
        return true;
    }


    
}
