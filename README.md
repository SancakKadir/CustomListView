# Custom List View

AssignmentListView is an Android ListView widget which calculate image loading times.

## Usage
To use in an XML layout:
 - Include The Library into your project
 - Create the AssignmentView as `com.example.assignmentlistview.ui.list.AssignmentList`

Download
--------
Use Gradle:

- Project gradle file
```gradle
repositories {
  google()
  mavenCentral()
  maven { url 'https://jitpack.io' }
}
```
- App gradle file

```
dependencies {
  implementation 'com.github.SancakKadir:CustomListView:1.0.1'
}
```

**Setup**:
    
    assignmentImageViews.setup(listOf(AssignmentListView.ItemEntity("url")))
