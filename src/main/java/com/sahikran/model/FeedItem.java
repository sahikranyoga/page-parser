package com.sahikran.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = FeedItem.Builder.class)
public final class FeedItem {
    
    private final String itemText;
    private final LocalDate itemDate;
    private final String itemUrl;
    private final String itemDescription;

    private FeedItem(String itemText, LocalDate itemDate, String itemUrl, String itemDescription){
        this.itemText = itemText;
        this.itemDate = itemDate;
        this.itemUrl = itemUrl;
        this.itemDescription = itemDescription;
    }

    public String getItemText() {
        return itemText;
    }

    public LocalDate getItemDate() {
        return itemDate;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public String getItemDescription(){
        return itemDescription;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((itemDate == null) ? 0 : itemDate.hashCode());
        result = prime * result + ((itemText == null) ? 0 : itemText.hashCode());
        result = prime * result + ((itemUrl == null) ? 0 : itemUrl.hashCode());
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
        FeedItem other = (FeedItem) obj;
        if (itemDate == null) {
            if (other.itemDate != null)
                return false;
        } else if (!itemDate.equals(other.itemDate))
            return false;
        if (itemText == null) {
            if (other.itemText != null)
                return false;
        } else if (!itemText.equals(other.itemText))
            return false;
        return true;
    }

    @JsonPOJOBuilder(withPrefix = "add")
    public static final class Builder{
        private String itemText;
        private LocalDate itemDate;
        private String itemUrl;
        private String itemDescription;

        public Builder addItemText(String itemText){
            Objects.requireNonNull(itemText, "item text can not be empty");
            this.itemText = itemText;
            return this;
        }

        public Builder addItemDate(LocalDate itemDate){
            Objects.requireNonNull(itemDate, "item date can not be empty");
            this.itemDate = itemDate;
            return this;
        }

        public Builder addItemUrl(String itemUrl){
            Objects.requireNonNull(itemUrl, "item url can not be empty");
            this.itemUrl = itemUrl;
            return this;
        }

        public Builder addItemDescription(String itemDescription){
            this.itemDescription = itemDescription;
            return this;
        }

        public FeedItem build(){
            return new FeedItem(itemText, itemDate, itemUrl, itemDescription);
        }
    }

    
}
