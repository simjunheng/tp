---
layout: page
title: User Guide
---
[![codecov](https://codecov.io/gh/AY2122S2-CS2103T-W14-2/tp/branch/master/graph/badge.svg?token=N3IGRH3TN0)](https://codecov.io/gh/AY2122S2-CS2103T-W14-2/tp)

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## **1. Introduction**
Coach2K22 is a desktop app that helps busy sports coaches **organise their overwhelming lists of contacts and messy weekly schedules.** It also provides them with a **platform to visualise defensive and offensive plays** as the game unfolds

### 1.1 Quick Start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest '.jar' file from [here](https://github.com/AY2122S2-CS2103T-W14-2/tp/releases).

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

## **2. Features**

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

#### 2.1.5 Clearing all contact entries: `clear-p`

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


#### 2.1.9 Adding a strength : `strength-add`

Add a strength to a selected person from our contact list.

Format: `strength-add INDEX  STRENGTH_DESCRIPTION`

Examples:
* `strength-add 1 Great stamina` adds the strength "Great stamina" to the 1st person in the contact list.

#### 2.1.10 Adding a weakness : `weakness-add`

Add a weakness to a selected person from our contact list.

Format: `weakness-add INDEX  WEAKNESS_DESCRIPTION`

Examples:
* `weakness-add 1 Poor defensive abilities` adds the weakness "Poor defensive abilities" to the 1st person in the contact list.

#### 2.1.11 Adding a miscellaneous note : `misc-add`

Add a miscellaneous note to a selected person from our contact list.

Format: `misc-add INDEX  NOTE_DESCRIPTION`

Examples:
* `misc-add 1 Likes ice cream` adds the miscellaneous note "Likes ice cream" to the 1st person in the contact list.


#### 2.1.12 Deleting a strength : `strength-del`

Delete a strength from a selected person from our contact list.

Format: `strength-del INDEX  STRENGTH_INDEX`

Examples:
* `strength-del 1 1` deletes the first strength from the first person in the contact list.

<div markdown="block" class="alert alert-info">

**:information_source: Key things to take note of:**<br>

* Deletes the strength at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The strength index refers to the index number shown in the strength list of the respective person.
* Both indices **must be a positive integer** 1, 2, 3, …​

</div>


#### 2.1.13 Deleting a weakness : `weakness-del`

Delete the weakness from a selected person from our contact list.

Format: `weakness-del INDEX  WEAKNESS_INDEX`

Examples:
* `weakness-del 1 1` deletes the first weakness from the first person in the contact list.

<div markdown="block" class="alert alert-info">

**:information_source: Key things to take note of:**<br>

* Deletes the weakness at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The weakness index refers to the index number shown in the weakness list of the respective person.
* Both indices **must be a positive integer** 1, 2, 3, …​

</div>


#### 2.1.14 Deleting a miscellaneous note : `misc-del`

Delete the miscellaneous note from a selected person from our contact list.

Format: `misc-del INDEX  NOTE_INDEX`

Examples:
* `misc-del 1 1` deletes the first miscellaneous note from the first person in the contact list.

<div markdown="block" class="alert alert-info">

**:information_source: Key things to take note of:**<br>

* Deletes the miscellaneous note at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The note index refers to the index number shown in the misc. list of the respective person.
* Both indices **must be a positive integer** 1, 2, 3, …​

</div>

#### 2.1.15 Sorting list of persons by strengths : `sort-strength`

Sorts the list of persons by total strengths in descending order.

Format: `sort-strength`

#### 2.1.16 Sorting list of persons by weaknesses : `sort-weakness`

Sorts the list of persons by total weaknesses in descending order.

Format: `sort-weaknesses`


### 2.2 Task Management

#### 2.2.1 Listing all tasks : `list-t`

Shows a list of all tasks in our task list.

Format: `list-t`

#### 2.2.2 Adding a task: `add-t`

Adds a task to our task list.

Format: `add-t n/NAME d/DATE st/STARTTIME et/ENDTIME [t/TAG_NAME]…​ [c/PERSON_NAME]…​`

Examples:
* `add-t n/Welcome Tea d/24-04-2022 st/09:00 et/12:00 t/Socials c/Alex Yeoh`


<div markdown="block" class="alert alert-info">

**:information_source: Key things to take note of:**<br>

* `PERSON_NAME` has to be present in the contact list for them to be tagged to a task.

</div>

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** A task can have any number of tags (including 0)<br>

:bulb: **Tip:** A task can also be assigned to multiple persons (including 0)

</div>

#### 2.2.3 Deleting a task: `del-t`

Delete a task from our task list.

Format: `del-t INDEX`

Examples:
* `del-t 2` deletes the second task in the task list.

**:information_source: Key things to take note of:**<br>

* Deletes the task at the specified `INDEX`.
* The index can be obtained by referring to the indicated task index on the displayed task list.
* Index values start from 1 and are always positive integers.

#### 2.2.4 Editing a task: `edit-t`

Edit a task from our task list.

Format: `edit-t INDEX [n/NAME] [d/DATE] [st/STARTTIME] [et/ENDTIME] [t/TAG_NAME]…​ [c/PERSON_NAME]…​`

Examples:
* `edit-t 2 d/29-04-2022 et/10:00` edits the date and end time of the second task into `29-04-2022` and  `10:00` respectively.
* `edit-t 1 n/PR Event t/` edits the name of the first task to `PR Event` and clears all existing tags.

#### 2.2.5 Clear all task entries : `clear-t`

Clear all tasks or tasks on a selected date from our task list.

Format: `clear-t [d/DATE]`

Examples:
* `clear-t 2022-10-10` clears all tasks on the date given.

<div markdown="block" class="alert alert-info">

**:information_source: Key things to take note of:**<br>

* Clears all tasks on the specified `DATE`.
* Date must be in the format `yyyy-mm-dd`.

</div>

#### 2.2.6 Adding a tag : `tag-add-t`

Add a tag to a selected task from our task list.

Format: `tag-add-t INDEX TAG_NAME`

Examples:
* `tag-add-t 1 important` adds the tag "important" to the first task in the list.


#### 2.2.7 Deleting a tag : `tag-del-t`

Delete a tag from a selected task in our task list.

Format: `tag-del-t INDEX TAG_NAME`

Examples:
* `tag-add-t 1 important` removes the tag "important" from the first task in the list.

<div markdown="block" class="alert alert-info">

**:information_source: Key things to take note of:**<br>

* `TAG` must be an exact match for it to be recognised.
</div>

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

#### 2.2.9 Locating contacts tagged to a task : `get-person`

Pull out the contact information of persons tagged to a task.

Format: `get-person INDEX`

Examples:
* `get-person 2` pulls out the contact information of persons tagged to the second task.

#### 2.2.10 Sorting tasks by date : `sort-date`

Sort the task list by date, in order of the task whose deadline is earlier.

Format: `sort-date`

### 2.3 Strategic Planning

#### 2.3.1 Load new background image : `load-court`

Load a new background image in the strategy tab.

Format: `load-court IMAGE_NAME`

Examples:
* `load-court basketball` loads and sets the image `basketball.png` as the background image of strategy tab.

<div markdown="block" class="alert alert-info">

**:information_source: Key things to take note of:**<br>

* Loads the given image from the filepath `courts/IMAGE_NAME.png`.
* File must exist and be in `png` format in a folder named `courts` in the same directory as the JAR file (folder will be automatically generated).

</div>

#### 2.3.2 Adding new players: `add-player`

Add a new player to the strategy board.

Format: `add-player PLAYER_NAME`

Examples: 
* `add-player Messi` adds a new player named `Messi` in the strategy board.


<div markdown="block" class="alert alert-info">

**:information_source: Key things to take note of:**<br>

* `PLAYER_NAME` is case-sensitive e.g. `John Cena` will NOT match `john Cena`.
* `PLAYER_NAME` name can not be empty and its length must be less or equal to `24` characters.
* `PLAYER_NAME` must be unique and can NOT contain the character `/`.

</div>

#### 2.3.3 Removing players: `del-player`

Remove a player from the strategy board.

Format: `del-player PLAYER_NAME`

As mentioned above, the player name is case-sensitive.

Examples:
* `del-player Messi` removes the player named `Messi` from the strategy board.

#### 2.3.4 Moving a player to a coordinate: `move`

Move a player to a coordinate on the strategy board.

Format: `move PLAYER_NAME x/X_COORDINATE y/Y_COORDINATE`

As mentioned above, the player name is case-sensitive.

Example:
* `move Messi x/0 y/0` moves the player named `Messi` to the top left corner of the strategy board.

#### 2.3.5 Export strategy board as image file: `export`

Exports current view of the strategy board as an image to the users local device. 

Format: `export`

### 2.4 General

#### 2.4.1 Viewing help: `help`

Shows a message explaining how to access the help page.

Format: `help`

#### 2.4.2 Exiting the program : `exit`

Exits the program.

Format: `exit`


--------------------------------------------------------------------------------------------------------------------

## **3. FAQ**

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Coach2k22 home folder.

**Q**: What is the purpose of having a separate command for listing player strengths and weaknesses<br>
**A**: These functions allow coach to judge players based on their respective strengths/weaknesses for improved judgement of abilities, analyzing their liabilities, and strategically choosing the right player for the right purpose.
--------------------------------------------------------------------------------------------------------------------

## **4. Command summary**

### 4.1 Contact Management

| Action                 | Format, Examples                                                                                                                                             |
|------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **List**               | `list-p`                                                                                                                                                     |
| **Add**                | `add-p n/NAME p/PHONE_NUMBER a/ADDRESS e/EMAIL [t/TAG_NAME]…​` <br> e.g., `add-p n/Johnson p/83918273 a/Woodlands Avenue 4 e/johnson@gmail.com t/Hustlers` |
| **Del**                | `del-p INDEX`<br> e.g., `del-p 1`                                                                                                                            |
| **Edit**               | `edit-p INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [t/TAG_NAME]…​` <br> e.g., `edit-p 1 p/98273712 e/johndoe@example.com`                                   |
| **Clear**              | `clear-p`                                                                                                                                                    |
| **Add Tag**            | `tag-add-p INDEX TAG_NAME`<br> e.g., `tag-add-p 1 Public Relations`                                                                                          |
| **Del Tag**            | `tag-del-p INDEX TAG_NAME`<br> e.g., `tag-del-p 1 Team`                                                                                                      |
| **Find**               | `find-p [n/NAME]…​ [t/TAG]…​`<br> e.g., `find-p n/Alex n/Charlotte t/team1 t/team2`                                                                     |
| **Add Strength**       | `strength-add INDEX  STRENGTH_DESCRIPTION`<br> e.g., `strength-add 1 Great stamina`                                                                          |
| **Add Weakness**       | `weakness-add INDEX  WEAKNESS_DESCRIPTION`<br> e.g., `weakness-add 1 Poor defensive abilities`                                                               |
| **Add Miscellaneous**  | `misc-add INDEX  NOTE_DESCRIPTION`<br> e.g., `misc-add 1 Likes ice cream`                                                                                    |
| **Del Strength**       | `strength-del INDEX  STRENGTH_INDEX`<br> e.g., `strength-del 1 1`                                                                                            |
| **Del Weakness**       | `weakness-del INDEX  WEAKNESS_INDEX`<br> e.g., `weakness-del 1 1`                                                                                            |
| **Del Miscellaneous**  | `misc-del INDEX  NOTE_INDEX`<br> e.g., `misc-del 1 1`                                                                                                        |
| **Sort by Strengths**  | `sort-strength`                                                                                                                                              |
| **Sort by Weaknesses** | `sort-weakness`<br/>                                                                                                                                              |

### 4.2 Task Management

| Action           | Format, Examples                                                                  |
|------------------|-----------------------------------------------------------------------------------|
| **List**         | `list-t`                                                                          |
| **Add**          | `add-t n/NAME d/DATE st/STARTTIME et/ENDTIME [t/TAG_NAME]…​ [c/PERSON_NAME]…​`<br> e.g., `add-t n/Welcome Tea d/24-04-2022 st/09:00 et/12:00 t/Socials c/Alex Yeoh`|
| **Del**          | `del-t INDEX`<br> e.g., `del-p 1`                                                 | 
| **Edit**         | `edit-t INDEX [n/NAME] [d/DATE] [st/STARTTIME] [et/ENDTIME] [t/TAG_NAME]…​ [c/PERSON_NAME]…​` <br> e.g., `edit-t 2 d/29-04-2022 et/10:00`|
| **Clear**        | `clear-t [d/DATE]`<br> e.g., `clear-t 2022-10-10`                                 |
| **Add Tag**      | `tag-add-t INDEX TAG_NAME` <br> e.g., `tag-add-t 1 important`                     |
| **Del Tag**      | `tag-del-t INDEX TAG_NAME` <br> e.g., `tag-del-t 1 important`                     |
| **Find**         | `find-t [n/NAME]…​ [t/TAG]…​`<br> e.g., `find-p n/Meeting n/Training t/team1 t/team2` |
| **Get Person**   | `get-person INDEX`<br> e.g., `get-person 2`                                       |
| **Sort By Date** | `sort-date`                                                                       |

### 4.3 Strategic Planning

| Action            | Format, Examples                                                        |
|-------------------|-------------------------------------------------------------------------|
| **Load BG Image** | `load-court IMAGE_NAME`<br> e.g., `load-court basketball`               |
| **Add**           | `add-player PLAYER_NAME`<br> e.g., `add-player Messi`                   |
| **Del**           | `del-player PLAYER_NAME`<br> e.g., `del-player Messi`                   |
| **Move**          | `move PLAYER_NAME x/X_COORDINATE y/Y_COORDINATE`<br> e.g., `move Messi x/0 y/0` |
| **Export**        | `export`                                                                |


### 4.4 General

| Action       | Format, Examples        |
|--------------|-------------------------|
|  **Help**    | `help`                  |
|  **Exit**    | `exit`                  |

--------------------------------------------------------------------------------------------------------------------

## **5. Glossary**

| Term               | Definition                                                                       |
|--------------------|----------------------------------------------------------------------------------|
|**GUI** | The *Graphical User Interface (GUI)* allows program interaction through graphics             |
|**CLI** | The *Command Line Interface (CLI)* allows program interaction through commands               |

