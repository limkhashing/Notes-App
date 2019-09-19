# Notes Android App
Sample Apps with Google Architecture Components, MVVM and AndroidX libraries. Able to add, edit and delete notes

* Followed [Coding in Flow tutorial](https://www.youtube.com/playlist?list=PLrnPJCHvNZuDihTpkRs6SpZhqgBqPU118)
* Referred other [Github Repo](https://github.com/berkeatac/Notes-App) 


1. LiveData:
* subscribe on create. When there is changes, changes is done on background thread. 
* sample: LiveData<List<Note>> 
* Observe sample: noteViewModel.getAllNotes().observe

2. ViewModel:
* Pattern, with Repository as a bridge between Database model and ViewModel
* Using ViewModelProviders. Example: ViewModelProviders.of(this).get(NoteViewModel.class);

3. Room : 
* Database, annotation @Entity, @PrimaryKey, @Dao, @Insert, @Update, @Delete, @Database (this can have lot of entities), @Query, Dao (interface)

4. send back activity result using setResult

5. UI: 
* Use preview pane design. Text on the left, design on the right. Click Preview on the right side, below gradle taskbar
* NumberPicker
* use style TextAppearance.Medium, Large, etc
* tools:listItem="@layout/note_item, useful for previewing the list 
* Menu resources. app:showAsAction="ifRoom" will show on the menu if there is any space. 
