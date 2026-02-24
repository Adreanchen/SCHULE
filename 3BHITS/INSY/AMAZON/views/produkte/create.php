<?php

use yii\helpers\Html;

/** @var yii\web\View $this */
/** @var app\models\Produkte $model */
/** @var $dropdown */

$this->title = Yii::t('app', 'Create Produkte');
$this->params['breadcrumbs'][] = ['label' => Yii::t('app', 'Produktes'), 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="produkte-create">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
        'dropdown' => $dropdown
    ]) ?>

</div>
