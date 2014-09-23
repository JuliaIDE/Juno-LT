(ns lt.plugins.juno.menus
  (:require [lt.objs.menu :as menu :refer [cmd-item]]
            [lt.objs.platform :as platform]
            [lt.objs.sidebar.command :as cmd]
            [lt.util.dom :as dom]
            [lt.object :as object])
  (:require-macros [lt.macros :refer [behavior]]))

;; Application menus

(defn main-menu []
  (menu/set-menubar
   [(when (platform/mac?)
      {:label "" :submenu [{:label "Hide Light Table" :key "h" :selector "hide:"}
                           {:label "Hide Others" :key "h" :modifiers "cmd-alt" :selector "hideOtherApplications:"}
                           {:type "separator"}
                           (cmd-item "Quit" :quit {:key "q"})]})

    {:label "File" :submenu [(cmd-item "New file" :julia.new)
                             (cmd-item "New plain file" :new-file)
                             (cmd-item "Open file" :open-file)
                             {:label "Open folder" :click #(do
                                                             (cmd/exec! :workspace.show :force)
                                                             (cmd/exec! :workspace.add-folder))}
                             (cmd-item "Navigator" :navigate-workspace-transient)
                             {:type "separator"}
                             (cmd-item "Save file" :save)
                             (cmd-item "Save file as..." :save-as)
                             (cmd-item "Close file" :tabs.close {:key "w"})
                             (cmd-item "Reopen closed file" :reminisce.reopen-tab)]}

    (if (platform/mac?)
      {:label "Edit" :submenu [(cmd-item "Undo" :editor.undo {:selector "undo:" :key "z"})
                               (cmd-item "Redo" :editor.redo {:selector "redo:" :key "z" :modifiers "cmd-shift"})
                               {:type "separator"}
                               (cmd-item "Cut" :editor.cut {:selector "cut:" :key "x"})
                               (cmd-item "Copy" :editor.copy {:selector "copy:" :key "c"})
                               (cmd-item "Paste" :editor.paste {:selector "paste:" :key "v"})
                               {:type "separator"}
                               (cmd-item "Select Block" :editor.select-block {:key "a" :modifiers "cmd-shift"})
                               (cmd-item "Select All" :editor.select-all {:selector "selectAll:" :key "a"})
                               {:type "separator"}
                               (cmd-item "Comment Selection" :toggle-comment-selection)]}
      {:label "Edit" :submenu [(cmd-item "Undo" :editor.undo)
                               (cmd-item "Redo" :editor.redo)
                               {:type "separator"}
                               (cmd-item "Cut" :editor.cut)
                               (cmd-item "Copy" :editor.copy)
                               (cmd-item "Paste" :editor.paste)
                               {:type "separator"}
                               (cmd-item "Select Block" :editor.select-block)
                               (cmd-item "Select All" :editor.select-all)
                               {:type "separator"}
                               (cmd-item "Comment Selection" :toggle-comment-selection)]})

    {:label "View" :submenu [(cmd-item "Workspace" :workspace.show)
                             (cmd-item "Navigator" :navigate-workspace-transient)
                             (cmd-item "Commands" :show-commandbar-transient)
                             (cmd-item "Console" :toggle-console)
                             {:type "separator"}
                             (cmd-item "Object Browser" :julia.browser)
                             {:type "separator"}
                             {:label "Julia Packages" :click #(platform/open "http://pkg.julialang.org/")}
                             {:label "Julia Docs" :click #(platform/open "http://docs.julialang.org/")}
                             {:type "separator"}
                             (cmd-item "Clear Console" :clear-console)]}

    {:label "Evaluation" :submenu [(cmd-item "Eval Block" :eval-editor-form)
                             (cmd-item "Eval & Move" :eval.one.move)
                             (cmd-item "Eval All" :eval-editor)
                             {:type "separator"}
                             (cmd-item "Show/hide Docs" :editor.doc.toggle)
                             (cmd-item "Show/hide Methods" :editor.methods.toggle)
                             {:type "separator"}
                             (cmd-item "Interrupt Julia" :editor.interrupt-clients)
                             (cmd-item "Kill Julia" :editor.kill-clients)]}

    {:label "Help" :submenu [{:label "Juno Docs" :click #(platform/open "http://junolab.org/docs/")}
                             {:label "Julia Docs" :click #(platform/open "http://docs.julialang.org/")}
                             {:label "Report an Issue" :click #(platform/open "https://github.com/one-more-minute/Julia-LT/issues?state=open")}]}]))

;; Setup

(set! menu/main-menu main-menu)

(def gui (js/require "nw.gui"))

(set! (-> gui .-Window .get .-title) "Juno")

;; Result menu

(behavior ::result-menu!
          :triggers #{:menu!}
          :reaction (fn [this ev]
                      (-> (menu/menu [{:label "Remove result"
                                       :click (fn [] (object/raise this :clear!))}])
                          (menu/show-menu (.-clientX ev) (.-clientY ev)))
                      (dom/prevent ev)
                      (dom/stop-propagation ev)))
