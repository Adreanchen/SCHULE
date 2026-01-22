<?php

use yii\helpers\Html;
use yii\bootstrap5\ActiveForm;

/** @var yii\web\View $this */
/** @var app\models\Produkte $model */
/** @var yii\widgets\ActiveForm $form */
?>

<div class="produkte-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'ProduktID')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'Produktname')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'Produktkategorie')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'Stueckpreis')->textInput(['maxlength' => true,'type'=>'number']) ?>

    <?= $form->field($model, 'LieferantenID')->dropDownList($dropdown) ?>

    <div class="form-group">
        <?= Html::submitButton(Yii::t('app', 'Save'), ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
