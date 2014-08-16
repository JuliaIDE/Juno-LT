if(!lt.util.load.provided_QMARK_('lt.plugins.flow')) {
goog.provide('lt.plugins.flow');
goog.require('cljs.core');
goog.require('crate.core');
goog.require('crate.core');
goog.require('lt.objs.editor');
goog.require('lt.objs.editor');
goog.require('lt.object');
goog.require('lt.object');
goog.require('lt.util.dom');
goog.require('lt.util.dom');
lt.plugins.flow.callback = (function callback(s,f){return setTimeout(f,(s * 1000));
});
lt.plugins.flow.show = (function show(dom){return $(dom).show(200);
});
lt.plugins.flow.hide = (function hide(dom){return $(dom).hide(200);
});
lt.plugins.flow.__BEH__animate_on_show = (function __BEH__animate_on_show(this$){$(lt.object.__GT_content.call(null,this$)).hide();
return lt.plugins.flow.callback.call(null,0,(function (){return lt.plugins.flow.show.call(null,lt.object.__GT_content.call(null,this$));
}));
});
lt.object.behavior_STAR_.call(null,new cljs.core.Keyword("lt.plugins.flow","animate-on-show","lt.plugins.flow/animate-on-show",3222768235),new cljs.core.Keyword(null,"reaction","reaction",4441361819),lt.plugins.flow.__BEH__animate_on_show,new cljs.core.Keyword(null,"triggers","triggers",2516997421),new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"object.instant","object.instant",773332388),null], null), null));
lt.plugins.flow.__BEH__clear_mark = (function __BEH__clear_mark(this$){lt.plugins.flow.hide.call(null,lt.object.__GT_content.call(null,this$));
return lt.plugins.flow.callback.call(null,0.2,(function (){if(cljs.core.truth_(cljs.core.deref.call(null,new cljs.core.Keyword(null,"ed","ed",1013907473).cljs$core$IFn$_invoke$arity$1(cljs.core.deref.call(null,this$)))))
{CodeMirror.off(new cljs.core.Keyword(null,"line","line",1017226086).cljs$core$IFn$_invoke$arity$1(cljs.core.deref.call(null,this$)),"change",new cljs.core.Keyword(null,"listener","listener",2360064038).cljs$core$IFn$_invoke$arity$1(cljs.core.deref.call(null,this$)));
CodeMirror.off(new cljs.core.Keyword(null,"line","line",1017226086).cljs$core$IFn$_invoke$arity$1(cljs.core.deref.call(null,this$)),"delete",new cljs.core.Keyword(null,"delete","delete",3973413149).cljs$core$IFn$_invoke$arity$1(cljs.core.deref.call(null,this$)));
if(cljs.core.truth_(new cljs.core.Keyword(null,"mark","mark",1017248319).cljs$core$IFn$_invoke$arity$1(cljs.core.deref.call(null,this$))))
{new cljs.core.Keyword(null,"mark","mark",1017248319).cljs$core$IFn$_invoke$arity$1(cljs.core.deref.call(null,this$)).clear();
} else
{}
lt.object.raise.call(null,this$,new cljs.core.Keyword(null,"clear","clear",1108650431));
return lt.object.raise.call(null,this$,new cljs.core.Keyword(null,"cleared","cleared",1870681886));
} else
{return null;
}
}));
});
lt.object.behavior_STAR_.call(null,new cljs.core.Keyword("lt.plugins.flow","clear-mark","lt.plugins.flow/clear-mark",2987949941),new cljs.core.Keyword(null,"reaction","reaction",4441361819),lt.plugins.flow.__BEH__clear_mark,new cljs.core.Keyword(null,"triggers","triggers",2516997421),new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"clear!","clear!",3951036134),null], null), null));
lt.plugins.flow.__BEH__ex_clear = (function __BEH__ex_clear(this$){lt.plugins.flow.hide.call(null,lt.object.__GT_content.call(null,this$));
return lt.plugins.flow.callback.call(null,0.2,(function (){if(cljs.core.truth_(lt.objs.editor.__GT_cm_ed.call(null,new cljs.core.Keyword(null,"ed","ed",1013907473).cljs$core$IFn$_invoke$arity$1(cljs.core.deref.call(null,this$)))))
{lt.objs.editor.remove_line_widget.call(null,lt.objs.editor.__GT_cm_ed.call(null,new cljs.core.Keyword(null,"ed","ed",1013907473).cljs$core$IFn$_invoke$arity$1(cljs.core.deref.call(null,this$))),new cljs.core.Keyword(null,"widget","widget",4520824246).cljs$core$IFn$_invoke$arity$1(cljs.core.deref.call(null,this$)));
} else
{}
lt.object.raise.call(null,this$,new cljs.core.Keyword(null,"clear","clear",1108650431));
return lt.object.raise.call(null,this$,new cljs.core.Keyword(null,"cleared","cleared",1870681886));
}));
});
lt.object.behavior_STAR_.call(null,new cljs.core.Keyword("lt.plugins.flow","ex-clear","lt.plugins.flow/ex-clear",4169443295),new cljs.core.Keyword(null,"reaction","reaction",4441361819),lt.plugins.flow.__BEH__ex_clear,new cljs.core.Keyword(null,"triggers","triggers",2516997421),new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"clear!","clear!",3951036134),null], null), null));
}

//# sourceMappingURL=jupiter_compiled.js.map