---
layout: page
title: User Guide
---
[![codecov](https://codecov.io/gh/AY2122S2-CS2103T-W14-2/tp/branch/master/graph/badge.svg?token=N3IGRH3TN0)](https://codecov.io/gh/AY2122S2-CS2103T-W14-2/tp)

#User Guide

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## 1. Introduction
Coach2K22 is a desktop app that helps busy sports coaches **organise their overwhelming lists of contacts and messy weekly schedules.** It also provides them with a **platform to visualise defensive and offensive plays** as the game unfolds

### 1.1 Quick Start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest '.jar' file.

1. Copy the file to the folder you want to use as the _home folder_ for your copy of Coach2k22.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)
    
1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will list all the possible commands.<br>
   Some example commands you can try:

   * **`list-p`** : Lists all contacts.

   * **`add-p`**`n/John Doe p/98765432 e/johnd@example.com` : Adds a contact named `John Doe`.

   * **`del-p`**`3` : Deletes the 3rd contact shown in the current list.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

### 1.2 User Guide Icons

| Icon               | Meaning                                                       |
|--------------------|---------------------------------------------------------------|
|:information_source:| This icon indicates important information to be taken note of |
|:bulb:               | This icon indicates useful tips for the users                |

--------------------------------------------------------------------------------------------------------------------

## 2. Features

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

### 2.1 Contact Management

#### 2.1.1 Listing all contacts : `list-p`

Shows a list of all persons in our contact list.

Format: `list-p`

#### 2.1.2 Adding a person: `add-p`

Adds a person to our contact list.

Format: `add-p n/NAME p/PHONE_NUMBER a/ADDRESS e/EMAIL [t/TAG_NAME]…​`

Examples:
* `add-p n/Johnson p/83918273 a/Woodlands Avenue 4 e/johnson@gmail.com t/Hustlers`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

#### 2.1.3 Deleting a person: `del-p`

Delete a person from our contact list.

Format: `del INDEX`

Examples:
* `del-p 1` deletes the first person in the contact list.

#### 2.1.4 Editing a person: `edit-p`

Edit a person from our contact list.

Format: `edit-p INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [t/TAG_NAME]…​`

Examples:
* `edit-p 1 p/98273712 e/johndoe@example.com` edits the phone number and email addresses of the 1st person into `98273712` and  `johndoe@example.com` respectively.
* `edit-p 2 n/Alan Walker t/` edits the name of the 2nd person and clear all existing tags.

#### 2.1.5 Clearing all entries: `clear-p`

Clear all entries from our contact list.

Format: `clear-p`

#### 2.1.6 Adding a tag : `tag-add-p`

Add tags to a selected person from our contact list.

Format: `tag-add INDEX TAG_NAME`

Examples:
* `tag-add 1 Public Relations` adds the tag `Public Relations` to the first person in the contact list.


#### 2.1.7 Deleting a tag : `tag-del-p`

Add tags to a selected person from our contact list.

Format: `tag-del-p INDEX TAG_NAME`

Examples:
* `tag-del 1 Team` deletes the tag `Team` from the first person in the contact list.


#### 2.1.8 Locating persons by keyword : `find-p`

Find persons matching any of the given keywords from our contact list.
Users can choose to find by `NAME`(s), `TAG`(s), or both.

Format: `find [n/NAME]…​ [t/TAG]…​`

Examples:
* `find-p n/Alan t/team1`
* `find-p n/Alan`
* `find-p t/team1`
* `find-p n/Alex n/Charlotte t/team1 t/team2`

<div markdown="block" class="alert alert-info">

**:information_source: Key things to take note of:**<br>

* One of the optional items e.g. `[n/NAME]` must be present for the command to work.
* The search is case-insensitive e.g. `hans` will match `Hans`.
* The order of the keywords does not matter e.g. `n/hans n/bo` will return the same result as `n/bo n/hans`.
* Only full words will be matched e.g. `Han` will not match `Hans`.
* Persons matching at least one keyword will be returned e.g. `n/Hans n/Bo` will return the persons `Hans Gruber` and `Bo Yang`. 

</div>


#### 2.1.9 Adding a note : `note-add`

Add a note to a selected person from our contact list.

Format: `note-add INDEX  NOTE_DESCRIPTION`

Examples:
* `note-add 1 Surgery Scheduled for tomorrow` adds the note "Surgery Scheduled for tomorrow" to the 1st person in the contact list.


#### 2.1.10 Deleting a note : `note-del`

Delete the note to a selected person from our contact list.

Format: `note-del INDEX  NOTE_INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `note-del 1 1` deletes the first note from the first person in the contact list.


### 2.2 Task Management

#### 2.2.1 Listing all tasks : `list-t`

Shows a list of all tasks in our task list.

Format: `list-t`

#### 2.2.2 Adding a task: `add-t`

* (To be filled up by @pragya)

<div>
**:information_source: Key things to take note of:**<br>

* `PERSON_NAME` has to be present in the contact list for them to be tagged to a task.

</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A task can have any number of tags (including 0)
</div>

#### 2.2.3 Deleting a task: `del-t`

* (To be filled up by @pragya)

#### 2.2.4 Editing a person: `edit-t`

* (To be filled up by @pragya)

#### 2.2.5 Clearing all entries: `clear-t`

* (To be filled up by @abdul)

#### 2.2.6 Adding a tag : `tag-add-t`

* (To be filled up by @juayhee)

#### 2.2.7 Deleting a tag : `tag-del-t`

* (To be filled up by @juayhee)

#### 2.2.8 Locating tasks by keyword : `find-t`

Find tasks matching any of the given keywords from our task list.
Users can choose to find by `NAME`(s), `TAG`(s), or both.

Format: `find-t [n/NAME]…​ [t/TAG]…​`

Examples:
* `find-t n/Meeting t/team1`
* `find-t n/Meeting`
* `find-t t/team1`
* `find-t n/Meeting n/Training t/team1 t/team2`

<div markdown="block" class="alert alert-info">

**:information_source: Key things to take note of:**<br>

* One of the optional items e.g. `[n/NAME]` must be present for the command to work.
* The search is case-insensitive e.g. `meeting` will match `Meeting`.
* The order of the keywords does not matter e.g. `n/meeting n/shareholder` will return the same result as `n/shareholder n/meeting`.
* Only full words will be matched e.g. `Meeting` will not match `Meetings`.
* Tasks matching at least one keyword will be returned e.g. `n/Meeting n/Shareholders` will return the persons `Engagement with Shareholders` and `Annual Meeting`.

</div>

### 2.3 Strategic Planning

#### 2.3.1 Load new background image: `load-court`

* (To be filled up by @abdul)

#### 2.3.2 Clearing all entries: `clear-s`

* (To be filled up by @xiaoteng)

#### 2.3.2 Adding new players: `add-s`

* (To be filled up by @xiaoteng)

#### 2.3.3 Moving a player to a coordinate: `move`

* (To be filled up by @xiaoteng)

#### 2.3.4 Export strategy board as image file: `export`

* (To be filled up by pragya)

#### 2.3.5 Exiting the program : `exit`

Exits the program.

Format: `exit`


--------------------------------------------------------------------------------------------------------------------

## 3. FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Coach2k22 home folder.

--------------------------------------------------------------------------------------------------------------------

## 4. Command summary

### 4.1 Contact Management
| Action       | Format, Examples                                                                                                                                              |
|--------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **List**     | `list-p`                                                                                                                                                      |
| **Add**      | `add-p n/NAME p/PHONE_NUMBER a/ADDRESS e/EMAIL [t/TAG_NAME]…​` <br> e.g., `add-p n/Johnson p/83918273 a/Woodlands Avenue 4 e/johnson@gmail.com t/Hustlers` |
| **Del**      | `del-p INDEX`<br> e.g., `del-p 1`                                                                                                                             |
| **Edit**     | `edit-p INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [t/TAG_NAME]…​` <br> e.g., `edit-p 1 p/98273712 e/johndoe@example.com`                                   |
| **Clear**    | `clear-p`                                                                                                                                                     |
| **Add Tag**  | `tag-add-p INDEX TAG_NAME`<br> e.g., `tag-add-p 1 Public Relations`                                                                                           |
| **Del Tag**  | `tag-del-p INDEX TAG_NAME`<br> e.g., `tag-del-p 1 Team`                                                                                                       |
| **Find**     | `find-p [n/NAME]…​ [t/TAG]…​`<br> e.g., `find-p n/Alex n/Charlotte t/team1 t/team2`                                                                     |
| **Add Note** | `note-add INDEX  NOTE_DESCRIPTION`<br> e.g., `note-add 1 Surgery Scheduled for tomorrow`                                                                      |
| **Del Note** | `note-del INDEX  NOTE_INDEX`<br> e.g., `note-del 1 1`                                                                                                         |

### 4.2 Task Management
| Action       | Format, Examples                                                                           |
|--------------|--------------------------------------------------------------------------------------------|
| **List**     | `list-p`                                                                                   |
| **Add**      | (to be filled up by @pragya)                                                               |
| **Del**      | (to be filled up by @pragya)                                                               | 
| **Edit**     | (to be filled up by @pragya)                                                               |
| **Clear**    | (to be filled up by @abdul)                                                                |
| **Add Tag**  | (to be filled up by @juayhee)                                                              |
| **Del Tag**  | (to be filled up by @juayhee)                                                              |
| **Find**     | `find-t [n/NAME]…​ [t/TAG]…​`<br> e.g., `find-p n/Meeting n/Training t/team1 t/team2`|

### 4.3 Strategic Planning
| Action         | Format, Examples                                                                           |
|----------------|--------------------------------------------------------------------------------------------|
| **Load Court** | (to be filled up by @abdul)                                                                |
| **Add**        | (to be filled up by @xiaoteng)                                                             |
| **Clear**      | (to be filled up by @xiaoteng)                                                             |
| **Move**       | (to be filled up by @xiaoteng)                                                             |
| **Export**     | (to be filled up by @pragya)                                                               |
| **Exit**       | `exit`                                                                                     |

--------------------------------------------------------------------------------------------------------------------

## 5. Glossary
| Term           | Definition                                                                       |
|----------------|----------------------------------------------------------------------------------|
| **GUI**        | The *Graphical User Interface (GUI)* allows program interaction through graphics |
| **CLI**        | The *Command Line Interface (CLI)* allows program interaction through commands   |
