package com.learn.interview.apis.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RestaurantModal {

    private long orderId;
    private String orderDate;
    private String orderTime;
    private Address deliveryAddress;
    private String orderStatus;

    private long billId;
    private long customerId;
    private String invoiceNo;
    private String billDate;
    private long amount;
    private String status;

    private List<ItemModal> items;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemModal> getItems() {
        if(Objects.isNull(items))
            items = new ArrayList<>();
        return items;
    }
}


class ItemModal {

    private long itemId;
    private String invoiceNo;
    private String itemName;
    private float itemCost;

    /**
     * @return the itemId
     */
    public long getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the invoiceNo
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * @param invoiceNo the invoiceNo to set
     */
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemCost
     */
    public float getItemCost() {
        return itemCost;
    }

    /**
     * @param itemCost the itemCost to set
     */
    public void setItemCost(float itemCost) {
        this.itemCost = itemCost;
    }

    @Override
    public String toString() {
        return "ItemModal [itemId=" + itemId + ", invoiceNo=" + invoiceNo + ", itemName=" + itemName + ", itemCost="
                + itemCost + "]";
    }



}