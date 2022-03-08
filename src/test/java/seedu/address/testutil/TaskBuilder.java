package seedu.address.testutil;

import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;
import seedu.address.model.task.*;
import seedu.address.model.util.SampleDataUtil;

import java.util.HashSet;
import java.util.Set;

public class TaskBuilder {
    public static final String DEFAULT_NAME = "Meeting";
    public static final String DEFAULT_DATE = "09-10-2022";
    public static final String DEFAULT_START_TIME = "08:00";
    public static final String DEFAULT_END_TIME = "12:00";

    private Name name;
    private Date date;
    private StartTime startTime;
    private EndTime endTime;
    private Set<Tag> tags;

    /**
     * Creates a {@code TaskBuilder} with the default details.
     */
    public TaskBuilder() {
        this.name = new Name(DEFAULT_NAME);
        this.date = new Date(DEFAULT_DATE);
        this.startTime = new StartTime(DEFAULT_START_TIME);
        this.endTime = new EndTime(DEFAULT_END_TIME);
        this.tags = new HashSet<>();
    }

    /**
     * Creates a {@code TaskBuilder} with the data of {@code taskToCopy}.
     */
    public TaskBuilder(Task taskToCopy) {
        this.name = taskToCopy.getName();
        this.date = taskToCopy.getDate();
        this.startTime = taskToCopy.getStartTime();
        this.endTime = taskToCopy.getEndTime();
        this.tags = taskToCopy.getTags();
    }

    /**
     * Sets the {@code Name} of the {@code Task} that we are building.
     */
    public TaskBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code Date} of the {@code Task} that we are building.
     */
    public TaskBuilder withDate(String date) {
        this.date = new Date(date);
        return this;
    }

    /**
     * Sets the {@code StartTime} of the {@code Task} that we are building.
     */
    public TaskBuilder withStartTime(String startTime) {
        this.startTime = new StartTime(startTime);
        return this;
    }

    /**
     * Sets the {@code EndTime} of the {@code Task} that we are building.
     */
    public TaskBuilder withEndTime(String endTime) {
        this.endTime = new EndTime(endTime);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Task} that we are building.
     */
    public TaskBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Creates {@code Task} and returns it.
     */
    public Task build() {
        return new Task(name, date, startTime, endTime, tags);
    }
}

