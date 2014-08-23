(ns lt.plugins.flow
  (:require [lt.util.dom :as dom]
            [lt.object :as object]
            [lt.objs.editor :as ed]
            [crate.core :as crate])
  (:require-macros [lt.macros :refer [behavior defui]]))

(defn callback [s f]
  (js/setTimeout f (* s 1000)))

(defn show [dom]
  (-> dom js/$ (.show 200)))

(defn hide [dom]
  (-> dom js/$ (.hide 200)))

(behavior ::animate-on-show
          :triggers #{:object.instant}
          :reaction (fn [this]
                      (-> this object/->content js/$ .hide)
                      (callback 0 #(show (object/->content this)))
                      (callback 200 #(when (:ed @this)
                                       (ed/refresh (:ed @this))))))

(behavior ::clear-mark
          :triggers #{:clear!}
          :reaction (fn [this]
                      (hide (object/->content this))
                      (callback 0.2
                       #(when (deref (:ed @this))
                          (js/CodeMirror.off (:line @this) "change" (:listener @this))
                          (js/CodeMirror.off (:line @this) "delete" (:delete @this))
                          (when (:mark @this) (.clear (:mark @this)))
                          (object/raise this :clear)
                          (object/raise this :cleared)))))

(behavior ::ex-clear
          :triggers #{:clear!}
          :reaction (fn [this]
                      (hide (object/->content this))
                      (callback 0.2
                       #(do
                          (when (ed/->cm-ed (:ed @this))
                            (ed/remove-line-widget (ed/->cm-ed (:ed @this)) (:widget @this)))i
                          (object/raise this :clear)
                          (object/raise this :cleared)))))
