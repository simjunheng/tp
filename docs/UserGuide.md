---
layout: page
title: User Guide
---
[![codecov](https://codecov.io/gh/AY2122S2-CS2103T-W14-2/tp/branch/master/graph/badge.svg?token=N3IGRH3TN0)](https://codecov.io/gh/AY2122S2-CS2103T-W14-2/tp)

#User Guide

Coach2K22 is a desktop app that helps busy sports coaches **organise their overwhelming lists of contacts and messy weekly schedules.** It also provides them with a **platform to visualise defensive and offensive plays** as the game unfolds

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest '.jar' file.

1. Copy the file to the folder you want to use as the _home folder_ for your copy of Coach2k22.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will list all the possible commands.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts.

   * **`add`**`n/John Doe p/98765432 e/johnd@example.com` : Adds a contact named `John Doe`.

   * **`delete`**`3` : Deletes the 3rd contact shown in the current list.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

## Contact Management

### Listing all contacts : `list-t`

Shows a list of all persons in our contact list.

Format: `list`


### Adding a person: `add`

Adds a person to our contact list.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL [t/TAG_NAME]…​`

<details>
<summary> Contact Management </summary>
<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>
</details>>


Examples:
* `add n/Johnson p/83918273 e/johnson@gmail.com t/Hustlers`


### Deleting a person: `del`

Delete a person from our contact list.

Format: `del INDEX`

Examples:
* `del 1` deletes the first person in the contact list.


### Adding a tag : `tag-add`

Add tags to a selected person from our contact list.

Format: `tag-add INDEX  TAG_NAME`

Examples:
* `tag-add 1 Public Relations` adds the tag `Public Relations` to the first person in the contact list.


### Deleting a tag : `tag-del`

Add tags to a selected person from our contact list.

Format: `tag-del INDEX  TAG_INDEX`

Examples:
* `tag-del 1 1` deletes the first tag from the first person in the contact list.


### Locating persons by keyword : `find`

Find persons matching any of the given keywords from our contact list.
Users can choose to find by `NAME`(s), `TAG`(s), or both.

Format: `find [n/NAME]…​ [t/TAG]…​`

* One of the optional items e.g. `[n/NAME]` must be present for the command to work. 

Examples:
* `find n/Alan t/team1`
* `find n/Alan`
* `find t/team1`
* `find n/Alex n/Charlotte t/team1 t/team2`


### Adding a note : `note-add`

Add a note to a selected person from our contact list.

Format: `note-add INDEX  NOTE_DESCRIPTION`

Examples:
* `note-add 1 Surgery Scheduled for tomorrow` adds the note "Surgery Scheduled for tomorrow" to the 1st person in the contact list.


### Deleting a note : `note-del`

Delete the note to a selected person from our contact list.

Format: `note-del INDEX  NOTE_INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `note-del 1 1` deletes the first note from the first person in the contact list.


### Listing all the commands : `help`

Show a list of all the commands with their respective format and a short description of what they do.

Format: `help`


### Exiting the program : `exit`

Exits the program.

Format: `exit`

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Coach2k22 home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action       | Format, Examples                                                                                                   |
|--------------|--------------------------------------------------------------------------------------------------------------------|
| **List**     | `list`                                                                                                             |
| **Add**      | `add n/NAME p/PHONE_NUMBER e/EMAIL [t/TAG]…​` <br> e.g., `add n/Johnson p/83918273 e/johnson@gmail.com t/Hustlers` |
| **Del**      | `del INDEX`<br> e.g., `del 1`                                                                                      |
| **Add Tag**  | `tag-add INDEX  TAG_NAME`<br> e.g., `tag-add 1 Public Relations`                                                   |
| **Del Tag**  | `tag-del INDEX  TAG_INDEX`<br> e.g., `tag-del 1 1`                                                                 |
| **Find**     | `find [n/NAME]…​ [t/TAG]…​`<br> e.g., `find n/Alex n/Charlotte t/team1 t/team2`                                                     |
| **Add Note** | `note-add INDEX  NOTE_DESCRIPTION`<br> e.g., `note-add 1 Surgery Scheduled for tomorrow`                           |
| **Del Note** | `note-del INDEX  NOTE_INDEX`<br> e.g., `note-del 1 1`                                                              |
| **Help**     | `help`                                                                                                             |
| **Exit**     | `exit`                                                                                                             |
