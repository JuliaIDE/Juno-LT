(ns lt.plugins.flow
  (:require [lt.util.dom :as dom]
            [lt.object :as object]
            [lt.objs.editor :as editor]
            [crate.core :as crate])
  (:require-macros [lt.macros :refer [behavior defui]]))

(defn callback [s f]
  (js/setTimeout f (* s 1000)))

(defn show [dom]
  (-> dom js/$ (.show 200)))

(defn hide [dom]
  (-> dom js/$ (.hide 200)))

(defn has-valid-editor? [result]
  (editor/->cm-ed (:ed @result)))

(behavior ::animate-on-show
          :triggers #{:object.instant}
          :reaction (fn [result]
                      (-> result object/->content js/$ .hide)
                      (callback 0 #(show (object/->content result)))
                      (callback 200 #(when (has-valid-editor? result)
                                       (editor/refresh (:ed @result))))))

(behavior ::clear-mark
          :triggers #{:clear!}
          :reaction (fn [result]
                      (hide (object/->content result))
                      (callback 0.2
                       #(when (has-valid-editor? result)
                          (js/CodeMirror.off (:line @result) "change" (:listener @result))
                          (js/CodeMirror.off (:line @result) "delete" (:delete @result))
                          (when (:mark @result) (.clear (:mark @result)))
                          (object/raise result :clear)
                          (object/raise result :cleared)))))

(behavior ::ex-clear
          :triggers #{:clear!}
          :reaction (fn [ex]
                      (hide (object/->content ex))
                      (callback 0.2
                       #(do
                          (when (has-valid-editor? ex)
                            (editor/remove-line-widget (editor/->cm-ed (:ed @ex)) (:widget @ex)))i
                          (object/raise ex :clear)
                          (object/raise ex :cleared)))))
