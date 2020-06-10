package com.test1.art_test1.api;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;

/**
 * Property of CODIX SA
 * Date: 6/4/2020 Time: 5:45 PM
 * <p>
 * TODO: WRITE THE DESCRIPTION HERE
 *
 * @author lparvov
 */
public class PostBody {
    @Length(max = 10)
    private String name;

    @Digits(integer = 5, fraction = 3)
    private BigDecimal amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}