package com.ioiox.dei.core.beans;

import com.ioiox.dei.core.constant.DeiGlobalConstant;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Super class for all Double Egg Island entities.
 * Each Double Egg Island project related Entity should be inherited from this entity.
 */
public class BaseDeiEntity {
    public static final int INIT_VERSION_NUM = DeiGlobalConstant.ONE;
    private Long sid;
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;
    private Integer versionNum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDeiEntity that = (BaseDeiEntity) o;
        return sid.equals(that.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid);
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    public enum ShowColumn implements BaseDeiEnum {
        ID("sid", "主键ID"),
        CREATED_BY("createdBy", "创建人"),
        CREATED_TIME("createdTime", "创建时间"),
        UPDATED_BY("updatedBy", "更新人"),
        UPDATED_TIME("updatedTime", "更新时间"),
        VERSION_NUM("versionNum", "版本号"),
        ;
        private final String code;
        private final String desc;

        ShowColumn(final String code,
                   final String desc) {
            this.code = code;
            this.desc = desc;
        }

        @Override
        public String getCode() {
            return code;
        }

        @Override
        public String getDesc() {
            return desc;
        }

        public static List<String> allColumns() {
            return Stream.of(values())
                    .map(ShowColumn::getCode)
                    .collect(Collectors.toList());
        }
    }
}
