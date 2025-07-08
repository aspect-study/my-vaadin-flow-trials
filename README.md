# 📚 Vaadin Flow Study Project

This repository is a personal learning space where I explore and experiment with the full range of [Vaadin Flow](https://vaadin.com/flow) components and features — from layouting and data binding to routing, theming, and integration with Java backend logic.

As a Java developer, my goal is to understand not just how to use Vaadin, but how it works under the hood: how components behave, how state is managed, and how to build clean, modular UIs using Java alone.

---

## 🎯 Purpose

This project is not a production-ready app — it's a **living lab** for studying:

- 🧩 Vaadin Flow components and their APIs
- 🎨 Layout behavior and styling (Lumo, Flexbox, CSS Grid)
- 🔄 Data binding, forms, and validation
- 🧭 Routing, navigation, and view composition
- 🌗 Theming (light/dark mode) and dynamic styling
- 🧰 Utility patterns for reusable UI logic
- 🧪 Integration with Java backend logic and design principles

---

## 🛠️ Tech Stack

- **Java 17+**
- **Vaadin Flow 24**
- **Maven**
- **Spring Boot**
- **IntelliJ IDEA**

---
📁 Project Structure
views/ – All component demos and layout experiments

views/main/MainLayout.java – App shell with navigation and theming

views/common/ui/util/UiUtils.java – Reusable UI helpers

frontend/ – Static assets and theme overrides (if needed)

🧠 Why This Exists
As a backend-focused developer, I wanted to explore how Vaadin lets me build modern UIs without writing JavaScript — while still giving me full control over layout, behavior, and state. This project is my way of learning by doing, documenting patterns, and building intuition around Vaadin’s component model.

📸 Screenshots
(Coming soon as I build out more views)

🧼 GitHub Language Detection Fix
To ensure GitHub recognizes this as a Java project (not JavaScript), I’ve added a .gitattributes file:
```bash
frontend/* linguist-vendored
node_modules/* linguist-vendored
*.js linguist-vendored
*.ts linguist-vendored
*.css linguist-vendored
```
📄 License
MIT

🙋‍♂️ Want to Follow Along?
Feel free to fork this repo, explore the code, or suggest improvements. This is a study-first, build-later kind of project — and I’m always open to learning more.
```
Let me know if you want to add badges (like Java version, build status), or if you'd like help writing a CONTRIBUTING.md or setting up GitHub Pages to showcase your work!
```
---

## ▶️ How to Run

```bash
mvn clean install
mvn spring-boot:run
```
---
✅ Full List of All Free Vaadin Flow Components (Apache 2.0 Licensed)
📥 Input Components
TextField

PasswordField

TextArea

EmailField

NumberField

IntegerField

BigDecimalField

Checkbox

CheckboxGroup

RadioButtonGroup

Select

ComboBox

ListBox

MultiSelectListBox

DatePicker

TimePicker

Slider

CustomField

🧾 Data Display
Grid (basic features)

TreeGrid

VirtualList

Details

Accordion

Tabs

TabSheet

Tooltip (part of many components)

Badge

Avatar

AvatarGroup

📦 Layout & Structure
VerticalLayout

HorizontalLayout

FlexLayout

FormLayout

SplitLayout

AppLayout

Scroller

DrawerToggle

Div, Span, Paragraph, H1 to H6

🚦 Buttons & Actions
Button

Anchor

Icon

ThemeIcon

ContextMenu (basic functionality is free)

💬 Dialogs & Notifications
Dialog

ConfirmDialog

Notification

📎 Miscellaneous / Utility
Upload (basic version, with memory or file buffer)

ProgressBar

RichTextEditor

IFrame

Image

Video

🔄 Data Binding & Providers
These aren’t visible components, but part of the framework:

Binder<T> — powerful form data binding and validation

DataProvider<T> — dynamic or lazy-loading data source

ValueProvider<T, V>

HasValue, HasComponents, etc.

🧰 System / Base Utilities
UI (access, navigate, push)

Page (for metadata)

Router, @Route, RouterLink, BeforeEnterEvent, etc.

@Theme, @CssImport, @JsModule, @Tag

❗ What’s Not Free?
To recap, the following require a Pro or Enterprise license:

Charts

Spreadsheet

Board

Crud

PDFViewer

Timeline

Collaboration Engine

💡 Tip: How to Check Yourself
You can always explore Vaadin’s component browser:

🔗 https://vaadin.com/components
🔗 https://vaadin.com/directory/
🔗 https://vaadin.com/docs/latest/components/icons/default-icons

Filter by License → Free
