(ns lt.plugins.juno.tutorial
  (:require [lt.object :as object]
            [lt.objs.command :as cmd]
            [lt.objs.files :as files]
            [lt.objs.plugins :as plugins]
            [lt.objs.editor :as editor]
            [lt.objs.editor.pool :as pool]
            [lt.objs.opener :as opener]
            [lt.objs.tabs :as tabs]
            [lt.plugins.reminisce :as reminisce])
  (:require-macros [lt.macros :refer [behavior]]))

(def juno-dir
  (->> [(files/join plugins/user-plugins-dir "Juno")
        (files/join plugins/plugins-dir "Juno-LT")]
       (filter files/exists?)
       first))

(def tutorial-text
  (-> (files/join juno-dir "tutorial.jl") files/open-sync :content))

(defn open-tutorial []
  (when-let [ed (let [ed (pool/create {:mime "text/julia"
                                       :tags [:editor.julia]
                                       :type-name "Julia"
                                       :name "Tutorial.jl"})]
                  (object/add-tags ed [:editor.transient])
                  (object/raise opener/opener :open ed)
                  (tabs/add! ed)
                  (tabs/active! ed)
                  ed)]
    (editor/set-val ed tutorial-text)
    ed))

(cmd/command {:command :juno.tutorial
              :desc "Julia: Open tutorial"
              :exec open-tutorial})

(behavior ::tutorial
          :triggers #{:fresh-start}
          :reaction open-tutorial)
