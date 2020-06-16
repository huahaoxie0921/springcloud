package com.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "product")
public class MallProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "product_name", nullable = false)
    private String productName;

    @Basic
    @Column(name = "product_type", nullable = false)
    private String productType;

    @Basic
    @Column(name = "product_icon", nullable = false)
    private String productIcon;

    @Basic
    @Column(name = "product_intro", nullable = false)
    private String productIntro;

    @Basic
    @CreatedDate
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Basic
    @LastModifiedDate
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    public MallProduct(String productName, String productType,
                       String productIcon, String productIntro) {

        this.productName = productName;
        this.productType = productType;
        this.productIcon = productIcon;
        this.productIntro = productIntro;
    }

    public static MallProduct invalid() {

        MallProduct invalid = new MallProduct("", "0", "", "");
        invalid.setId(-1L);
        return invalid;
    }

}
