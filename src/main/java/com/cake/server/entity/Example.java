package com.cake.server.entity;

public class Example {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column example.id
     *
     * @mbg.generated Mon Apr 02 15:44:57 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column example.name
     *
     * @mbg.generated Mon Apr 02 15:44:57 CST 2018
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column example.id
     *
     * @return the value of example.id
     *
     * @mbg.generated Mon Apr 02 15:44:57 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column example.id
     *
     * @param id the value for example.id
     *
     * @mbg.generated Mon Apr 02 15:44:57 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column example.name
     *
     * @return the value of example.name
     *
     * @mbg.generated Mon Apr 02 15:44:57 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column example.name
     *
     * @param name the value for example.name
     *
     * @mbg.generated Mon Apr 02 15:44:57 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}