package com.metaweb.gridworks.expr;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.metaweb.gridworks.expr.controls.ForEach;
import com.metaweb.gridworks.expr.controls.ForNonBlank;
import com.metaweb.gridworks.expr.controls.If;
import com.metaweb.gridworks.expr.controls.With;
import com.metaweb.gridworks.expr.functions.Get;
import com.metaweb.gridworks.expr.functions.Length;
import com.metaweb.gridworks.expr.functions.Slice;
import com.metaweb.gridworks.expr.functions.ToNumber;
import com.metaweb.gridworks.expr.functions.ToString;
import com.metaweb.gridworks.expr.functions.arrays.Join;
import com.metaweb.gridworks.expr.functions.arrays.Reverse;
import com.metaweb.gridworks.expr.functions.arrays.Sort;
import com.metaweb.gridworks.expr.functions.booleans.And;
import com.metaweb.gridworks.expr.functions.booleans.Not;
import com.metaweb.gridworks.expr.functions.booleans.Or;
import com.metaweb.gridworks.expr.functions.math.Ceil;
import com.metaweb.gridworks.expr.functions.math.Floor;
import com.metaweb.gridworks.expr.functions.math.Ln;
import com.metaweb.gridworks.expr.functions.math.Log;
import com.metaweb.gridworks.expr.functions.math.Max;
import com.metaweb.gridworks.expr.functions.math.Min;
import com.metaweb.gridworks.expr.functions.math.Mod;
import com.metaweb.gridworks.expr.functions.math.Round;
import com.metaweb.gridworks.expr.functions.strings.EndsWith;
import com.metaweb.gridworks.expr.functions.strings.IndexOf;
import com.metaweb.gridworks.expr.functions.strings.LastIndexOf;
import com.metaweb.gridworks.expr.functions.strings.Replace;
import com.metaweb.gridworks.expr.functions.strings.Split;
import com.metaweb.gridworks.expr.functions.strings.StartsWith;
import com.metaweb.gridworks.expr.functions.strings.ToLowercase;
import com.metaweb.gridworks.expr.functions.strings.ToTitlecase;
import com.metaweb.gridworks.expr.functions.strings.ToUppercase;
import com.metaweb.gridworks.expr.functions.tests.IsBlank;
import com.metaweb.gridworks.expr.functions.tests.IsNotBlank;
import com.metaweb.gridworks.expr.functions.tests.IsNotNull;
import com.metaweb.gridworks.expr.functions.tests.IsNull;

public class ControlFunctionRegistry {

    static private Map<String, Function> s_nameToFunction = new HashMap<String, Function>();
    static private Map<Function, String> s_functionToName = new HashMap<Function, String>();
    
    static private Map<String, Control> s_nameToControl = new HashMap<String, Control>();
    static private Map<Control, String> s_controlToName = new HashMap<Control, String>();
    
    static public Function getFunction(String name) {
        return s_nameToFunction.get(name);
    }
    static public String getFunctionName(Function f) {
        return s_functionToName.get(f);
    }
    static public Set<Entry<String, Function>> getFunctionMapping() {
        return s_nameToFunction.entrySet();
    }

    static public Control getControl(String name) {
        return s_nameToControl.get(name);
    }
    static public String getControlName(Function f) {
        return s_controlToName.get(f);
    }
    static public Set<Entry<String, Control>> getControlMapping() {
        return s_nameToControl.entrySet();
    }

    static protected void registerFunction(String name, Function f) {
        s_nameToFunction.put(name, f);
        s_functionToName.put(f, name);
    }

    static protected void registerControl(String name, Control c) {
        s_nameToControl.put(name, c);
        s_controlToName.put(c, name);
    }

    static {
        registerFunction("toString", new ToString());
        registerFunction("toNumber", new ToNumber());
        
        registerFunction("toUppercase", new ToUppercase());
        registerFunction("toLowercase", new ToLowercase());
        registerFunction("toTitlecase", new ToTitlecase());
        
        registerFunction("get", new Get());
        registerFunction("slice", new Slice());
        registerFunction("substring", new Slice());
        registerFunction("replace", new Replace());
        registerFunction("split", new Split());
        registerFunction("length", new Length());
        
        registerFunction("indexOf", new IndexOf());
        registerFunction("lastIndexOf", new LastIndexOf());
        registerFunction("startsWith", new StartsWith());
        registerFunction("endsWith", new EndsWith());
        registerFunction("join", new Join());
        registerFunction("reverse", new Reverse());
        registerFunction("sort", new Sort());
        
        registerFunction("round", new Round());
        registerFunction("floor", new Floor());
        registerFunction("ceil", new Ceil());
        registerFunction("mod", new Mod());
        registerFunction("max", new Max());
        registerFunction("min", new Min());
        registerFunction("log", new Log());
        registerFunction("ln", new Ln());
        
        registerFunction("and", new And());
        registerFunction("or", new Or());
        registerFunction("not", new Not());
        registerFunction("isNull", new IsNull());
        registerFunction("isNotNull", new IsNotNull());
        registerFunction("isBlank", new IsBlank());
        registerFunction("isNotBlank", new IsNotBlank());

        registerControl("if", new If());
        registerControl("with", new With());
        registerControl("forEach", new ForEach());
        registerControl("forNonBlank", new ForNonBlank());
    }
}