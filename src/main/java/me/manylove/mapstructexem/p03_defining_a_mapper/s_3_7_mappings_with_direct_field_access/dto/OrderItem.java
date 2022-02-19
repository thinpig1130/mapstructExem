package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_7_mappings_with_direct_field_access.dto;

/**
 * @author Filip Hrisafov
 */
public class OrderItem {

    private String name;
    private Long quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
