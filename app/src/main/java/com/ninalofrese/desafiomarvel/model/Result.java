
package com.ninalofrese.desafiomarvel.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Result {

    @Expose
    private Characters characters;
    @Expose
    private List<Object> collectedIssues;
    @Expose
    private List<Object> collections;
    @Expose
    private Creators creators;
    @Expose
    private List<Date> dates;
    @Expose
    private Object description;
    @Expose
    private String diamondCode;
    @Expose
    private Long digitalId;
    @Expose
    private String ean;
    @Expose
    private Events events;
    @Expose
    private String format;
    @Expose
    private Long id;
    @Expose
    private List<Image> images;
    @Expose
    private String isbn;
    @Expose
    private String issn;
    @Expose
    private Long issueNumber;
    @Expose
    private String modified;
    @Expose
    private Long pageCount;
    @Expose
    private List<Price> prices;
    @Expose
    private String resourceURI;
    @Expose
    private Series series;
    @Expose
    private Stories stories;
    @Expose
    private List<Object> textObjects;
    @Expose
    private Thumbnail thumbnail;
    @Expose
    private String title;
    @Expose
    private String upc;
    @Expose
    private List<Url> urls;
    @Expose
    private String variantDescription;
    @Expose
    private List<Variant> variants;

    public Result() {
    }

    public Characters getCharacters() {
        return characters;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    public List<Object> getCollectedIssues() {
        return collectedIssues;
    }

    public void setCollectedIssues(List<Object> collectedIssues) {
        this.collectedIssues = collectedIssues;
    }

    public List<Object> getCollections() {
        return collections;
    }

    public void setCollections(List<Object> collections) {
        this.collections = collections;
    }

    public Creators getCreators() {
        return creators;
    }

    public void setCreators(Creators creators) {
        this.creators = creators;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public Long getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(Long digitalId) {
        this.digitalId = digitalId;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public Long getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(Long issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Stories getStories() {
        return stories;
    }

    public void setStories(Stories stories) {
        this.stories = stories;
    }

    public List<Object> getTextObjects() {
        return textObjects;
    }

    public void setTextObjects(List<Object> textObjects) {
        this.textObjects = textObjects;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }
}
